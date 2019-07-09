import { FlatTreeControl } from '@angular/cdk/tree';
import { Component, OnInit, Output, EventEmitter, Injectable } from '@angular/core';
import { LocationService } from 'src/app/services/location.service';
import { Response } from 'src/app/models/response.model';
import { CollectionViewer, SelectionChange } from '@angular/cdk/collections';
import { BehaviorSubject, merge, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Location } from 'src/app/models/location.model';
import { DepartmentService } from 'src/app/services/department.service';
import { Department } from 'src/app/models/department.model';
import { CategoryService } from 'src/app/services/category.service';
import { Category } from 'src/app/models/category.model';
import { SubCategoryService } from 'src/app/services/sub-category.service';
import { SubCategory } from 'src/app/models/sub-category.model';

interface ObjectDetails {
  id: string;
  name: string;
  type: string;
  showExpand: boolean;
  children?: ObjectDetails[];
}

const TREE_DEFAULT_NODES: ObjectDetails[] = [
  {
    id: 'root',
    name: 'Root',
    type: 'ROOT',
    showExpand: true,
    children: []
  }
];

@Component({
  selector: 'app-objects-tree',
  templateUrl: './objects-tree.component.html',
  styleUrls: ['./objects-tree.component.css']
})
export class ObjectsTreeComponent implements OnInit {

  @Output() public onNodeClickEvent = new EventEmitter<DynamicFlatNode>(true);

  constructor(private locationService: LocationService,
    private departmentService: DepartmentService,
    private categoryService: CategoryService,
    private subCategoryService: SubCategoryService) {
    this.treeControl = new FlatTreeControl<DynamicFlatNode>(this.getLevel, this.isExpandable);
    this.dataSource = new DynamicDataSource(this.treeControl, locationService, departmentService, categoryService, subCategoryService);

    this.dataSource.data = TREE_DEFAULT_NODES.map(obj => new DynamicFlatNode(obj.name, 0, true, obj));

  }

  ngOnInit() {

  }

  onNodeClick(node: DynamicFlatNode) {
    this.onNodeClickEvent.emit(node);
  }

  treeControl: FlatTreeControl<DynamicFlatNode>;

  dataSource: DynamicDataSource;

  getLevel = (node: DynamicFlatNode) => node.level;

  isExpandable = (node: DynamicFlatNode) => node.expandable;

  hasChild = (_: number, _nodeData: DynamicFlatNode) => _nodeData.expandable;

}


export class DynamicFlatNode {
  constructor(public name: string, public level = 1, public expandable = false,
    public objectDetails: ObjectDetails, public isLoading = false) { }
}

@Injectable()
export class DynamicDataSource {

  dataChange = new BehaviorSubject<DynamicFlatNode[]>([]);

  get data(): DynamicFlatNode[] { return this.dataChange.value; }
  set data(value: DynamicFlatNode[]) {
    this._treeControl.dataNodes = value;
    this.dataChange.next(value);
  }

  constructor(private _treeControl: FlatTreeControl<DynamicFlatNode>,
    private _locationService: LocationService,
    private _departmentService: DepartmentService,
    private _categoryService: CategoryService,
    private _subCategoryService: SubCategoryService) { }

  connect(collectionViewer: CollectionViewer): Observable<DynamicFlatNode[]> {
    this._treeControl.expansionModel.onChange.subscribe(change => {
      if ((change as SelectionChange<DynamicFlatNode>).added ||
        (change as SelectionChange<DynamicFlatNode>).removed) {
        this.handleTreeControl(change as SelectionChange<DynamicFlatNode>);
      }
    });

    return merge(collectionViewer.viewChange, this.dataChange).pipe(map(() => {
      return this.data
    }));
  }

  /** Handle expand/collapse behaviors */
  handleTreeControl(change: SelectionChange<DynamicFlatNode>) {
    if (change.added) {
      change.added.forEach(node => this.toggleNode(node, true));
    }
    if (change.removed) {
      change.removed.slice().reverse().forEach(node => this.toggleNode(node, false));
    }
  }

  /**
   * Toggle the node, remove from display list
   */
  toggleNode(node: DynamicFlatNode, expand: boolean) {
    const nodeIndex = this.data.indexOf(node);
    if (nodeIndex < 0) { // If no children, or cannot find the node, no op
      return;
    }
    if (expand) {
      if (node.objectDetails.type === 'ROOT') {
        Promise.all([
          this.loadLocationNodes()
        ]).then(
          (data: any) => {
            data = data instanceof Array ? data[0] : data;
            const nodes = data.map(objectDetails => new DynamicFlatNode(objectDetails.name, node.level + 1, objectDetails.showExpand, objectDetails));
            this.data.splice(nodeIndex + 1, 0, ...nodes);
            this.dataChange.next(this.data);
            node.isLoading = false;
          }, () => {

          }
        );
      } else if (node.objectDetails.type === 'LOCATION') {
        Promise.all([
          this.loadDepartmentNodes(node)
        ]).then(
          (data: any) => {
            data = data instanceof Array ? data[0] : data;
            const nodes = data.map(objectDetails => new DynamicFlatNode(objectDetails.name, node.level + 1, objectDetails.showExpand, objectDetails));
            this.data.splice(nodeIndex + 1, 0, ...nodes);
            this.dataChange.next(this.data);
            node.isLoading = false;
          }, () => {

          }
        );
      } else if (node.objectDetails.type === 'DEPARTMENT') {
        Promise.all([
          this.loadCategoryNodes(node)
        ]).then(
          (data: any) => {
            data = data instanceof Array ? data[0] : data;
            const nodes = data.map(objectDetails => new DynamicFlatNode(objectDetails.name, node.level + 1, objectDetails.showExpand, objectDetails));
            this.data.splice(nodeIndex + 1, 0, ...nodes);
            this.dataChange.next(this.data);
            node.isLoading = false;
          }, () => {

          }
        );
      } else if (node.objectDetails.type === 'CATEGORY') {
        Promise.all([
          this.loadSubCategoryNodes(node)
        ]).then(
          (data: any) => {
            data = data instanceof Array ? data[0] : data;
            const nodes = data.map(objectDetails => new DynamicFlatNode(objectDetails.name, node.level + 1, objectDetails.showExpand, objectDetails));
            this.data.splice(nodeIndex + 1, 0, ...nodes);
            this.dataChange.next(this.data);
            node.isLoading = false;
          }, () => {

          }
        );
      }
    } else {
      let count = 0;
      for (let i = nodeIndex + 1; i < this.data.length
        && this.data[i].level > node.level; i++ , count++) { }
      this.data.splice(nodeIndex + 1, count);

      this.dataChange.next(this.data);
      node.isLoading = false;
    }

  }

  public loadLocationNodes(): Promise<any> {
    return new Promise((resolve, reject) => {
      this._locationService.getLocations().subscribe((response: Response<Location[]>) => {
        if (response && response.responseCode === 'SUCCESS' && response.data) {
          let data = response.data.map((obj: Location) => {
            let objectDetails: ObjectDetails = {
              id: obj.id,
              name: obj.name,
              type: 'LOCATION',
              showExpand: true,
              children: []
            }
            return objectDetails;
          });
          resolve(data);
        } else {
          resolve([]);
        }
      }, reject);
    });

  }

  public loadDepartmentNodes(node: DynamicFlatNode): Promise<any> {
    return new Promise((resolve, reject) => {
      this._departmentService.getByLocation(node.objectDetails.id).subscribe((response: Response<Department[]>) => {
        if (response && response.responseCode === 'SUCCESS' && response.data) {
          let data = response.data.map((obj: Department) => {
            let objectDetails: ObjectDetails = {
              id: obj.id,
              name: obj.name,
              type: 'DEPARTMENT',
              showExpand: true,
              children: []
            }
            return objectDetails;
          });
          resolve(data);
        } else {
          resolve([]);
        }
      }, reject);
    });
  }

  public loadCategoryNodes(node: DynamicFlatNode): Promise<any> {
    return new Promise((resolve, reject) => {
      this._categoryService.getByDepartment(node.objectDetails.id).subscribe((response: Response<Category[]>) => {
        if (response && response.responseCode === 'SUCCESS' && response.data) {
          let data = response.data.map((obj: Category) => {
            let objectDetails: ObjectDetails = {
              id: obj.id,
              name: obj.name,
              type: 'CATEGORY',
              showExpand: true,
              children: []
            }
            return objectDetails;
          });
          resolve(data);
        } else {
          resolve([]);
        }
      }, reject);
    });
  }

  public loadSubCategoryNodes(node: DynamicFlatNode): Promise<any> {
    return new Promise((resolve, reject) => {
      this._subCategoryService.getByCategory(node.objectDetails.id).subscribe((response: Response<SubCategory[]>) => {
        if (response && response.responseCode === 'SUCCESS' && response.data) {
          let data = response.data.map((obj: SubCategory) => {
            let objectDetails: ObjectDetails = {
              id: obj.id,
              name: obj.name,
              type: 'SUB_CATEGORY',
              showExpand: false,
              children: []
            }
            return objectDetails;
          });
          resolve(data);
        } else {
          resolve([]);
        }
      }, reject);
    });
  }
}
import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DataSource } from '@angular/cdk/table';
import { BehaviorSubject, Observable, of, Subject } from 'rxjs';
import { catchError, takeUntil } from 'rxjs/operators';
import { Category } from 'src/app/models/category.model';
import { CategoryService } from 'src/app/services/category.service';
import { CategoryDetailsComponent } from '../category-view/category-details/category-details.component';
import { MatDialog } from '@angular/material';
import { ObjectTreeService } from 'src/app/services/object-tree.service';

@Component({
  selector: 'app-department-view',
  templateUrl: './department-view.component.html',
  styleUrls: ['./department-view.component.css']
})
export class DepartmentViewComponent implements OnInit, OnDestroy {

  displayedColumns: string[] = ['name', 'description'];

  dataSource: CategoryDataSource | null;

  departmentId: string;

  dialogRef: any;

  private _unsubscribeAll: Subject<any>;
  constructor(private _activatedRoute: ActivatedRoute,
    private _categoryService: CategoryService,
    public _matDialog: MatDialog,
    private _objectTreeService: ObjectTreeService) {

    this._unsubscribeAll = new Subject();
  }

  ngOnInit() {
    this.dataSource = new CategoryDataSource(this._categoryService);
    this._activatedRoute.params
      .pipe(takeUntil(this._unsubscribeAll))
      .subscribe(params => {
        this.departmentId = params.id;

        this.loadCategories();

      });
  }

  ngOnDestroy(): void {
    // Unsubscribe from all subscriptions
    this._unsubscribeAll.next();
    this._unsubscribeAll.complete();
  }

  loadCategories() {
    this.dataSource.loadCategories(this.departmentId);
  }

  showObjectDetails(category?: Category) {
    this.dialogRef = this._matDialog.open(CategoryDetailsComponent, {
      width: '600px',
      height: '420px',
      data: category || {}
    });

    this.dialogRef.afterClosed().subscribe(result => {
      if (result && result.safeClose) {
        this.saveDepartment(result.data);
      }
    });

  }

  saveDepartment(category: Category) {
    if (!category) {
      return;
    }

    if (category.id) {
      this._categoryService.updateCategory(category).subscribe((response) => {
        this.loadCategories();
        this._objectTreeService.nodeModified();
      });
    } else {
      category.department = {
        id: this.departmentId
      };
      this._categoryService.saveCategory(category).subscribe((response) => {
        this.loadCategories();
        this._objectTreeService.nodeModified();
      });
    }

  }

}

export class CategoryDataSource extends DataSource<any>
{

  private dataSourceSubject = new BehaviorSubject<Category[]>([]);

  /**
   * Constructor
   *
   * @param {CategoryService} _categoryService
   */
  constructor(
    private categoryService: CategoryService
  ) {
    super();

  }

  /**
   * Connect function called by the table to retrieve one stream containing the data to render.
   *
   * @returns {Observable<any[]>}
   */
  connect(): Observable<Category[]> {
    return this.dataSourceSubject.asObservable();
  }

  loadCategories(departmentId: string) {
    this.categoryService.getByDepartment(departmentId).pipe(
      catchError(() => of([]))
    ).subscribe(response => {
      return this.dataSourceSubject.next(response.data)
    });
  }

  /**
   * Disconnect
   */
  disconnect(): void {
    this.dataSourceSubject.complete();
  }
}
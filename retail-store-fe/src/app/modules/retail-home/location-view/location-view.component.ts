import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DataSource } from '@angular/cdk/table';
import { BehaviorSubject, Observable, of, Subject } from 'rxjs';
import { DepartmentService } from 'src/app/services/department.service';
import { Department } from 'src/app/models/department.model';
import { catchError, takeUntil } from 'rxjs/operators';
import { ObjectTreeService } from 'src/app/services/object-tree.service';
import { MatDialog } from '@angular/material';
import { DepartmentDetailsComponent } from '../department-view/department-details/department-details.component';

@Component({
  selector: 'app-location-view',
  templateUrl: './location-view.component.html',
  styleUrls: ['./location-view.component.css']
})
export class LocationViewComponent implements OnInit, OnDestroy {

  displayedColumns: string[] = ['name', 'description'];

  dataSource: DepartmentDataSource | null;

  locationId: string;

  dialogRef: any;

  private _unsubscribeAll: Subject<any>;
  constructor(private _activatedRoute: ActivatedRoute,
    private _departmentService: DepartmentService,
    public _matDialog: MatDialog,
    private _objectTreeService: ObjectTreeService) {

    this._unsubscribeAll = new Subject();
  }

  ngOnInit() {
    this.dataSource = new DepartmentDataSource(this._departmentService);
    this._activatedRoute.params
      .pipe(takeUntil(this._unsubscribeAll))
      .subscribe(params => {
        this.locationId = params.id;

        this.loadDepartments();

      });
  }

  ngOnDestroy(): void {
    // Unsubscribe from all subscriptions
    this._unsubscribeAll.next();
    this._unsubscribeAll.complete();
  }

  loadDepartments() {
    this.dataSource.loadDepartments(this.locationId);
  }

  showObjectDetails(department?: Department) {
    this.dialogRef = this._matDialog.open(DepartmentDetailsComponent, {
      width: '600px',
      height: '420px',
      data: department || {}
    });

    this.dialogRef.afterClosed().subscribe(result => {
      if (result && result.safeClose) {
        this.saveDepartment(result.data);
      }
    });

  }

  saveDepartment(department: Department) {
    if (!department) {
      return;
    }

    if (department.id) {
      this._departmentService.updateDepartment(department).subscribe((response) => {
        this.loadDepartments();
        this._objectTreeService.nodeModified();
      });
    } else {
      department.location = {
        id: this.locationId
      };
      this._departmentService.saveDepartment(department).subscribe((response) => {
        this.loadDepartments();
        this._objectTreeService.nodeModified();
      });
    }

  }
}


export class DepartmentDataSource extends DataSource<any>
{

  private departmentsSubject = new BehaviorSubject<Department[]>([]);

  /**
   * Constructor
   *
   * @param {DepartmentService} _departmentService
   */
  constructor(
    private _departmentService: DepartmentService
  ) {
    super();

  }

  /**
   * Connect function called by the table to retrieve one stream containing the data to render.
   *
   * @returns {Observable<any[]>}
   */
  connect(): Observable<Department[]> {
    return this.departmentsSubject.asObservable();
  }

  loadDepartments(locationId: string) {
    this._departmentService.getByLocation(locationId).pipe(
      catchError(() => of([]))
    ).subscribe(response => {
      return this.departmentsSubject.next(response.data)
    });
  }

  /**
   * Disconnect
   */
  disconnect(): void {
    this.departmentsSubject.complete();
  }
}
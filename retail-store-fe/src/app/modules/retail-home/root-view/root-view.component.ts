import { Component, OnInit } from '@angular/core';
import { DataSource } from '@angular/cdk/table';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { Location } from 'src/app/models/location.model';
import { LocationService } from 'src/app/services/location.service';
import { catchError } from 'rxjs/operators';
import { MatDialog } from '@angular/material';
import { LocationDetailsComponent } from '../location-view/location-details/location-details.component';
import { ObjectTreeService } from 'src/app/services/object-tree.service';

@Component({
  selector: 'app-root-view',
  templateUrl: './root-view.component.html',
  styleUrls: ['./root-view.component.css']
})
export class RootViewComponent implements OnInit {

  displayedColumns: string[] = ['name', 'description'];

  dataSource: LocationDataSource | null;

  dialogRef: any;

  constructor(private locationService: LocationService,
    public _matDialog: MatDialog,
    private _objectTreeService: ObjectTreeService) {

  }

  ngOnInit() {
    this.dataSource = new LocationDataSource(this.locationService);
    this.loadLocations();

  }

  loadLocations() {
    this.dataSource.loadLocations();
  }

  showObjectDetails(locationDetails?: Location) {
    this.dialogRef = this._matDialog.open(LocationDetailsComponent, {
      width: '600px',
      height: '420px',
      data: locationDetails || {}
    });

    this.dialogRef.afterClosed().subscribe(result => {
      if (result && result.safeClose) {
        this.saveLocation(result.data);
      }
    });

  }

  saveLocation(location: Location) {
    if (!location) {
      return;
    }

    if (location.id) {
      this.locationService.updateLocation(location).subscribe((response) => {
        this.loadLocations();
        this._objectTreeService.nodeModified();
      });
    } else {
      this.locationService.saveLocation(location).subscribe((response) => {
        this.loadLocations();
        this._objectTreeService.nodeModified();
      });
    }

  }

}


export class LocationDataSource extends DataSource<any>
{

  private locationsSubject = new BehaviorSubject<Location[]>([]);

  /**
   * Constructor
   *
   * @param {LocationService} _locationService
   */
  constructor(
    private _locationService: LocationService
  ) {
    super();

  }

  /**
   * Connect function called by the table to retrieve one stream containing the data to render.
   *
   * @returns {Observable<any[]>}
   */
  connect(): Observable<Location[]> {
    return this.locationsSubject.asObservable();
  }

  loadLocations() {
    this._locationService.getLocations().pipe(
      catchError(() => of([]))
    ).subscribe(response => {
      return this.locationsSubject.next(response.data)
    });
  }

  /**
   * Disconnect
   */
  disconnect(): void {
    this.locationsSubject.complete();
  }
}

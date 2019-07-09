import { Component, OnInit } from '@angular/core';
import { DataSource } from '@angular/cdk/table';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { Location } from 'src/app/models/location.model';
import { LocationService } from 'src/app/services/location.service';
import { catchError } from 'rxjs/operators';

@Component({
  selector: 'app-root-view',
  templateUrl: './root-view.component.html',
  styleUrls: ['./root-view.component.css']
})
export class RootViewComponent implements OnInit {

  displayedColumns: string[] = ['name', 'description'];

  dataSource: LocationDataSource | null;

  constructor(public locationService: LocationService) {

  }

  ngOnInit() {
    this.dataSource = new LocationDataSource(this.locationService);
    this.loadLocations();

  }

  loadLocations() {
    this.dataSource.loadLocations();
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

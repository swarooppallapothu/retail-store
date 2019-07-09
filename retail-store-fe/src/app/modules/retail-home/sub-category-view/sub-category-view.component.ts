import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DataSource } from '@angular/cdk/table';
import { BehaviorSubject, Observable, of, Subject } from 'rxjs';
import { catchError, takeUntil } from 'rxjs/operators';
import { SkuDetails } from 'src/app/models/sku-details.model';
import { SkuDetailsService } from 'src/app/services/sku-details.service';

@Component({
  selector: 'app-sub-category-view',
  templateUrl: './sub-category-view.component.html',
  styleUrls: ['./sub-category-view.component.css']
})
export class SubCategoryViewComponent implements OnInit, OnDestroy {
  displayedColumns: string[] = ['name', 'description'];

  dataSource: SkuDetailsDataSource | null;

  subCategoryId: string;

  private _unsubscribeAll: Subject<any>;
  constructor(private _activatedRoute: ActivatedRoute,
    private _skuDetailsService: SkuDetailsService) {

    this._unsubscribeAll = new Subject();
  }

  ngOnInit() {
    this.dataSource = new SkuDetailsDataSource(this._skuDetailsService);
    this._activatedRoute.params
      .pipe(takeUntil(this._unsubscribeAll))
      .subscribe(params => {
        this.subCategoryId = params.id;

        this.loadSkuDetails();

      });
  }

  ngOnDestroy(): void {
    // Unsubscribe from all subscriptions
    this._unsubscribeAll.next();
    this._unsubscribeAll.complete();
  }

  loadSkuDetails() {
    this.dataSource.loadSkuDetails(this.subCategoryId);
  }

}


export class SkuDetailsDataSource extends DataSource<any>
{

  private dataSourceSubject = new BehaviorSubject<SkuDetails[]>([]);

  /**
   * Constructor
   *
   * @param {CategoryService} _categoryService
   */
  constructor(
    private skuDetailsService: SkuDetailsService
  ) {
    super();

  }

  /**
   * Connect function called by the table to retrieve one stream containing the data to render.
   *
   * @returns {Observable<any[]>}
   */
  connect(): Observable<SkuDetails[]> {
    return this.dataSourceSubject.asObservable();
  }

  loadSkuDetails(subCategoryId: string) {
    this.skuDetailsService.getBySubCategory(subCategoryId).pipe(
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
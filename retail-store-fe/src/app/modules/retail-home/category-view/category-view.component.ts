import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DataSource } from '@angular/cdk/table';
import { BehaviorSubject, Observable, of, Subject } from 'rxjs';
import { catchError, takeUntil } from 'rxjs/operators';
import { SubCategory } from 'src/app/models/sub-category.model';
import { SubCategoryService } from 'src/app/services/sub-category.service';


@Component({
  selector: 'app-category-view',
  templateUrl: './category-view.component.html',
  styleUrls: ['./category-view.component.css']
})
export class CategoryViewComponent implements OnInit, OnDestroy {
  displayedColumns: string[] = ['name', 'description'];

  dataSource: SubCategoryDataSource | null;

  categoryId: string;

  private _unsubscribeAll: Subject<any>;
  constructor(private _activatedRoute: ActivatedRoute,
    private _subCategoryService: SubCategoryService) {

    this._unsubscribeAll = new Subject();
  }

  ngOnInit() {
    this.dataSource = new SubCategoryDataSource(this._subCategoryService);
    this._activatedRoute.params
      .pipe(takeUntil(this._unsubscribeAll))
      .subscribe(params => {
        this.categoryId = params.id;

        this.loadSubCategories();

      });
  }

  ngOnDestroy(): void {
    // Unsubscribe from all subscriptions
    this._unsubscribeAll.next();
    this._unsubscribeAll.complete();
  }

  loadSubCategories() {
    this.dataSource.loadSubCategories(this.categoryId);
  }

}


export class SubCategoryDataSource extends DataSource<any>
{

  private dataSourceSubject = new BehaviorSubject<SubCategory[]>([]);

  /**
   * Constructor
   *
   * @param {CategoryService} _categoryService
   */
  constructor(
    private subCategoryService: SubCategoryService
  ) {
    super();

  }

  /**
   * Connect function called by the table to retrieve one stream containing the data to render.
   *
   * @returns {Observable<any[]>}
   */
  connect(): Observable<SubCategory[]> {
    return this.dataSourceSubject.asObservable();
  }

  loadSubCategories(categoryId: string) {
    this.subCategoryService.getByCategory(categoryId).pipe(
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
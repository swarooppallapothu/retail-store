import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { HttpClientModule } from '@angular/common/http';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FlexLayoutModule } from '@angular/flex-layout';
import {
  MatToolbarModule, MatSidenavModule, MatTabsModule,
  MatTreeModule, MatIconModule, MatButtonModule, MatProgressBarModule, MatCardModule, MatTableModule, MatDialogModule, MatFormFieldModule, MatInputModule
} from '@angular/material';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RetailHomeComponent } from './modules/retail-home/retail-home.component';
import { ObjectsTreeComponent } from './modules/retail-home/objects-tree/objects-tree.component';
import { LocationViewComponent } from './modules/retail-home/location-view/location-view.component';
import { DepartmentViewComponent } from './modules/retail-home/department-view/department-view.component';
import { LocationService } from './services/location.service';
import { DepartmentService } from './services/department.service';
import { CategoryService } from './services/category.service';
import { SubCategoryService } from './services/sub-category.service';
import { SkuDetailsService } from './services/sku-details.service';
import { RootViewComponent } from './modules/retail-home/root-view/root-view.component';
import { CategoryViewComponent } from './modules/retail-home/category-view/category-view.component';
import { SubCategoryViewComponent } from './modules/retail-home/sub-category-view/sub-category-view.component';
import { LocationDetailsComponent } from './modules/retail-home/location-view/location-details/location-details.component';
import { DepartmentDetailsComponent } from './modules/retail-home/department-view/department-details/department-details.component';
import { CategoryDetailsComponent } from './modules/retail-home/category-view/category-details/category-details.component';
import { SubCategoryDetailsComponent } from './modules/retail-home/sub-category-view/sub-category-details/sub-category-details.component';
import { SkuDetailsComponent } from './modules/retail-home/sku-details-view/sku-details/sku-details.component';
import { ObjectTreeService } from './services/object-tree.service';


@NgModule({
  declarations: [
    AppComponent,
    RetailHomeComponent,
    ObjectsTreeComponent,
    RootViewComponent,
    LocationViewComponent,
    DepartmentViewComponent,
    CategoryViewComponent,
    SubCategoryViewComponent,
    LocationDetailsComponent,
    DepartmentDetailsComponent,
    CategoryDetailsComponent,
    SubCategoryDetailsComponent,
    SkuDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FlexLayoutModule,

    HttpClientModule,

    FormsModule,
    ReactiveFormsModule,

    MatToolbarModule,
    MatSidenavModule,
    MatTabsModule,
    MatTreeModule,
    MatIconModule,
    MatButtonModule,
    MatProgressBarModule,
    MatCardModule,
    MatTableModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule
  ],
  providers: [LocationService, DepartmentService, CategoryService, SubCategoryService, SkuDetailsService, ObjectTreeService],
  bootstrap: [AppComponent],
  entryComponents: [LocationDetailsComponent, DepartmentDetailsComponent, CategoryDetailsComponent, SubCategoryDetailsComponent, SkuDetailsComponent]
})
export class AppModule { }

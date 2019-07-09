import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HttpClientModule } from '@angular/common/http';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FlexLayoutModule } from '@angular/flex-layout';
import {
  MatToolbarModule, MatSidenavModule, MatTabsModule,
  MatTreeModule, MatIconModule, MatButtonModule, MatProgressBarModule, MatCardModule, MatTableModule
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

@NgModule({
  declarations: [
    AppComponent,
    RetailHomeComponent,
    ObjectsTreeComponent,
    RootViewComponent,
    LocationViewComponent,
    DepartmentViewComponent,
    CategoryViewComponent,
    SubCategoryViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FlexLayoutModule,

    HttpClientModule,

    MatToolbarModule,
    MatSidenavModule,
    MatTabsModule,
    MatTreeModule,
    MatIconModule,
    MatButtonModule,
    MatProgressBarModule,
    MatCardModule,
    MatTableModule
  ],
  providers: [LocationService, DepartmentService, CategoryService, SubCategoryService, SkuDetailsService],
  bootstrap: [AppComponent]
})
export class AppModule { }

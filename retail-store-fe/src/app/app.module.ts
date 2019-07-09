import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HttpClientModule } from '@angular/common/http';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FlexLayoutModule } from '@angular/flex-layout';
import {
  MatToolbarModule, MatSidenavModule, MatTabsModule,
  MatTreeModule, MatIconModule, MatButtonModule, MatProgressBarModule
} from '@angular/material';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RetailHomeComponent } from './modules/retail-home/retail-home.component';
import { ObjectsTreeComponent } from './modules/retail-home/objects-tree/objects-tree.component';
import { LocationViewComponent } from './modules/retail-home/location-view/location-view.component';
import { DepartmentViewComponent } from './modules/retail-home/department-view/department-view.component';
import { LocationService } from './services/location.service';
import { DepartmentService } from './services/department.service';

@NgModule({
  declarations: [
    AppComponent,
    RetailHomeComponent,
    ObjectsTreeComponent,
    LocationViewComponent,
    DepartmentViewComponent,

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
    MatProgressBarModule
  ],
  providers: [LocationService, DepartmentService],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RetailHomeComponent } from './modules/retail-home/retail-home.component';
import { LocationViewComponent } from './modules/retail-home/location-view/location-view.component';
import { DepartmentViewComponent } from './modules/retail-home/department-view/department-view.component';

const routes: Routes = [
  {
    path: 'retail-home',
    component: RetailHomeComponent,
    children: [                          //<---- child components declared here
      {
        path: 'location-view',
        component: LocationViewComponent
      },
      {
        path: 'department-view',
        component: DepartmentViewComponent
      }
    ]
  }, {
    path: '',
    redirectTo: '/retail-home',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

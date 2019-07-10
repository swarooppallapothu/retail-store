import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RetailHomeComponent } from './modules/retail-home/retail-home.component';
import { LocationViewComponent } from './modules/retail-home/location-view/location-view.component';
import { DepartmentViewComponent } from './modules/retail-home/department-view/department-view.component';
import { RootViewComponent } from './modules/retail-home/root-view/root-view.component';
import { CategoryViewComponent } from './modules/retail-home/category-view/category-view.component';
import { SubCategoryViewComponent } from './modules/retail-home/sub-category-view/sub-category-view.component';
import { LoginComponent } from './modules/public/login/login.component';
import { AuthGuard } from './services/auth.guard';

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'retail-home',
    component: RetailHomeComponent,
    canActivate: [AuthGuard],
    children: [                          //<---- child components declared here
      {
        path: 'root-view',
        component: RootViewComponent
      },
      {
        path: 'location-view/:id',
        component: LocationViewComponent
      },
      {
        path: 'department-view/:id',
        component: DepartmentViewComponent
      },
      {
        path: 'category-view/:id',
        component: CategoryViewComponent
      },
      {
        path: 'sub-category-view/:id',
        component: SubCategoryViewComponent
      }, {
        path: '**',
        redirectTo: 'root-view'
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

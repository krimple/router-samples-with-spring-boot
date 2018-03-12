import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Route, PreloadingStrategy, PreloadAllModules} from '@angular/router';
import { ContainerComponent } from './container/container.component';
import {CustomerComponent} from './customer/customer.component';
import {CustomerManagementComponent} from './customer-management/customer-management.component';
import {SalesPersonComponent} from './sales-person/sales-person.component';

const routes: Route[] = [
  { path: '', redirectTo: '/customer', pathMatch: 'full' }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes, { enableTracing: true, preloadingStrategy: PreloadAllModules })
  ],
  declarations: [ ContainerComponent ],
  exports: [ ContainerComponent ]
})
export class RoutingModule { }

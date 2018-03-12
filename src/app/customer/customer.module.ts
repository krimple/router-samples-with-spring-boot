import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Route, RouterModule } from '@angular/router';
import { CustomerComponent } from './customer.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import {RoutingModule} from '../routing.module';

const routes: Route[] = [
  {
    path: 'customer', component: CustomerComponent,
    children: [
      {path: '', component: CustomerListComponent}
    ]
  }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: [CustomerComponent, CustomerListComponent]
})
export class CustomerModule { }

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import {CustomerModule} from './customer/customer.module';
import {SalesPersonModule} from './sales-person/sales-person.module';
import {CustomerManagementModule} from './customer-management/customer-management.module';
import {RoutingModule} from './routing.module';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    CustomerManagementModule,
    HttpClientModule,
    RoutingModule,
    CustomerModule,
    SalesPersonModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

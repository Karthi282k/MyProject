import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { FetchCustomersComponent } from './fetch-customers/fetch-customers.component';
import { HomeComponent } from './home/home.component';
import { FetchCustomerByIdComponent } from './fetch-customer-by-id/fetch-customer-by-id.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'create-customer', component: CreateCustomerComponent },
  { path: 'fetch-customers', component: FetchCustomersComponent },
  { path: 'fetch-customers-by-id', component: FetchCustomerByIdComponent },
  { path: 'update', component: UpdateCustomerComponent },
  { path: 'homecom', component: HomeComponent  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

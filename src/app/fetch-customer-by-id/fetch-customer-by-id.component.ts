import { CustomerServiceService } from './../customer-service.service';
import { Component, OnInit } from '@angular/core';
import { Customer } from './../customer';

@Component({
  selector: 'app-fetch-customer-by-id',
  templateUrl: './fetch-customer-by-id.component.html',
  styleUrls: ['./fetch-customer-by-id.component.css']
})
export class FetchCustomerByIdComponent implements OnInit {
  customer: Customer= new Customer();
  submitted=false;


  constructor(private customerservice: CustomerServiceService) {
  }

  ngOnInit() {

  }
  newLibrary(): void {
    this.submitted = false;
    this.customer = new Customer();
  }
  fetch() {
    this.customerservice.findbyid(this.customer.cxId)
      .subscribe(data =>
        { this.customer=data;
          console.log(data);}
       , error =>
       {console.log(error);

  });
}
  onSubmit() {
    this.submitted = true;
    this.fetch();
  }
}

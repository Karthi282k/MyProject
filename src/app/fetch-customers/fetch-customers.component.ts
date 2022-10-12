import { CustomerServiceService } from './../customer-service.service';
import { Customer } from './../customer';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-fetch-customers',
  templateUrl: './fetch-customers.component.html',
  styleUrls: ['./fetch-customers.component.css']
})
export class FetchCustomersComponent implements OnInit {
  customers:Customer[]=[];

  constructor(private customerservice: CustomerServiceService) {

  }

  ngOnInit() {
    this.customerservice.findAll().subscribe(data => this.customers = data);
  }

}

import { DialogBoxComponent } from './../dialog-box/dialog-box.component';
import { CustomerServiceService } from './../customer-service.service';
import { Customer } from '../customer';
import { Component, OnInit } from '@angular/core';
import {  Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import {FormControl, Validators} from '@angular/forms'

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {

  customer: Customer;


  constructor(

      private router:Router,
        private userService:CustomerServiceService,
        public dialog:MatDialog,
        ) {
    this.customer = new Customer();
  }




  onSubmit() {
    this.userService.save(this.customer).subscribe(() => this.openDialog());
  }


  openDialog(){
    this.dialog.open(DialogBoxComponent,{
      width:'250px',
      data:"right click"
    })


}

  ngOnInit(): void {
  }
}

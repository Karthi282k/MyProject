import { FormControl, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {ErrorStateMatcher} from '@angular/material/core';
import { CustomerServiceService } from './../customer-service.service';
import { Customer } from '../customer';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { UpdateBoxComponent } from '../update-box/update-box.component';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {


  customer : Customer = new Customer();

  constructor(

        private customerService:CustomerServiceService,
        public dialog:MatDialog
        ) {
  }




  ngOnInit(): void {

  }

  Update(value:Customer){
    let body={
      cxId:value.cxId,
      cxName:value.cxName,
      mail:value.mail,
      gender:value.gender,
      contactNo:value.contactNo

    }
// this.customerService.update(body,this.customer.cxId).subscribe(result=>
//   {
//     console.log(result)
//   }
//   )
this.customerService.update(body).subscribe(result=>
  {
    console.log(result)
  }
  )
this.openDialog()
  }

  openDialog(){
    this.dialog.open(UpdateBoxComponent,{
      width:'250px',
      data:"right click"
    })


}


}

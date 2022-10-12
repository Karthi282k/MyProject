
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from './customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {
  private createCusUrl: string;
  private fetchAllUrl:string;
  private fetchById:string;
  private updteCustomer:string;

  constructor(private http:HttpClient) {
    this.createCusUrl = 'http://localhost:8080/createCustomers';
    this.fetchAllUrl='http://localhost:8080/fetchCustomers';
    this.fetchById='http://localhost:8080/fetchCustomerById';
    this.updteCustomer='http://localhost:8080/updateCustomer';
  }

  public findAll(): Observable<Customer[]> {
    return this.http.post<Customer[]>(this.fetchAllUrl, Customer);
  }
  public findbyid(cxId:number): Observable<Customer> {
    return this.http.post<Customer>(this.fetchById, cxId);
  }
  public save(customer: Customer) {
    return this.http.post<Customer>(this.createCusUrl, customer);
  }
  public update(customer:any):Observable<any>{
    return this.http.put(this.updteCustomer,customer);
  }
}



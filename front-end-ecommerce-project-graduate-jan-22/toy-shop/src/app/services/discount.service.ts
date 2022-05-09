import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Toy } from '../model/toy';
import { Discount } from '../model/discount';

@Injectable()
export class ToyService {
    http:HttpClient;

    
  
    //string containing URL of backend server
    URL : string = "http://localhost:8080/api/v1/discount";


    //using HttpCLient, inject the service into the constructor, allowing access to backend server
  constructor(http:HttpClient) { 
    this.http = http;
  }

  public getDiscount(productId:number):Observable<Discount>{
      let observable:Observable<Discount>
      let idURL = `${this.URL}/id/${productId}`
      observable=this.http.get<Discount>(this.URL);
      return observable;
  }
}
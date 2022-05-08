import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Toy } from '../model/toy';

@Injectable()
export class ToyService {
    http:HttpClient;

    
  
    //string containing URL of backend server
    URL : string = "http://localhost:8080/api/v1/products";


    //using HttpCLient, inject the service into the constructor, allowing access to backend server
  constructor(http:HttpClient) { 
    this.http = http;
  }

  //method to fetch all toys from backend server, through the observable
  public getAllToys():Observable<Toy[]>{
    let observable:Observable<Toy[]>
    observable=this.http.get<Toy[]>(this.URL);
    return observable;
  }

  //method to fetch a toy by id
  public getToyById(id:number):Observable<Toy>{
    let observable:Observable<Toy>
    let idURL = `${this.URL}/${id}`
    observable=this.http.get<Toy>(idURL);
    return observable;
  }

  //method to fetch toys by tag
  public getToyByTag(tag:string):Observable<Toy[]>{
    let observable:Observable<Toy[]>
    let tagURL = `${this.URL}/tag/${tag}`
    console.log(tagURL);
    
    observable=this.http.get<Toy[]>(tagURL);
    return observable;
  }
  //method to create toy
  public createToy(toy:Toy):Observable<any>{ // 
    let createToyURL = `${this.URL}/create` // form url http://localhost:8080/api/v1/products/create
    let observable=this.http.post(createToyURL, toy); // send post request with toy values in the request body
    console.log(toy);
    return observable;
  }
}
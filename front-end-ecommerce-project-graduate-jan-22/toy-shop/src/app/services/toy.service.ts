import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Toy } from '../model/toy';

@Injectable()
export class ToyService {
    http:HttpClient;
  
    //string containing URL of backend server
    URL : string = "http://localhost:3000/products";


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
  public getToyById(id:string):Observable<Toy[]>{
    let observable:Observable<Toy[]>
    let idURL = `${this.URL}/${id}`
    observable=this.http.get<Toy[]>(idURL);
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
  public createToy(toy:Toy):Observable<any>{
    let observable:any
    let createToyURL = `${this.URL}/create`
    observable=this.http.post<any>(createToyURL, toy);
    return observable;
  }
}
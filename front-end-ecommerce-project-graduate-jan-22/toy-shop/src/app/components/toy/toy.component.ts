import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToyService } from 'src/app/services/toy.service';
import { Toy } from '../../model/toy';

@Component({
  selector: 'app-toy',
  templateUrl: './toy.component.html',
  styleUrls: ['./toy.component.css']
})
export class ToyComponent implements OnInit {

  route:Router;
  toyArray:Toy[] = [];
  service:ToyService;
  pageNum:any;
  activeroute: ActivatedRoute;

  //Inject and initialise ToyService into contructor to allow access with backend
  constructor(service:ToyService, activeroute:ActivatedRoute,  route:Router) {
    this.service = service;
    this.activeroute = activeroute;
    this.route=route;
   }

  ngOnInit(): void {
    this.pageNum= this.activeroute.snapshot.paramMap.get('num');
    console.log(this.toyArray);
    this.getToys();
  }

    //Use toy service to access backend, and retrieve all products
  getToys(){
    let x = this.service.getProductPage(this.pageNum);
    x. subscribe((response)=>{this.toyArray = response;
    })
  }

  nextRoute(){
    this.route.navigate(['toys/page/', this.pageNum++])
  }

  prevRoute(){
    this.route.navigate(['toys/page/', this.pageNum--])
  }

}

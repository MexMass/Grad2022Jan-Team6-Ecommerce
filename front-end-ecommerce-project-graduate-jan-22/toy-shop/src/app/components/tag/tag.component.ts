import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Toy } from 'src/app/model/toy';
import { ToyService } from 'src/app/services/toy.service';

@Component({
  selector: 'app-tag',
  templateUrl: './tag.component.html',
  styleUrls: ['./tag.component.css']
})
export class TagComponent implements OnInit {
  toyArray:Toy[] = [];
  service:ToyService;
  postTag:any;
  activeroute:ActivatedRoute;
  
   //Inject and initialise ToyService into contructor to allow access with backend
  constructor(service:ToyService,activeroute:ActivatedRoute) { 
    this.service=service;
    this.activeroute=activeroute;
  }

  ngOnInit(): void {

    this.postTag = this.activeroute.snapshot.paramMap.get('tag');
    this.getToyByTag();
    
  }

  //Use toy service to access backend, and retrieve the products by their tags
  getToyByTag(){
    let x = this.service.getToyByTag(this.postTag);
    x. subscribe((response)=>{this.toyArray = response;
    })
  }


}

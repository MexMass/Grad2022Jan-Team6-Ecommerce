import { Component, OnInit } from '@angular/core';
import { ToyService } from 'src/app/services/toy.service';
import { Toy } from '../../model/toy';

@Component({
  selector: 'app-toy',
  templateUrl: './toy.component.html',
  styleUrls: ['./toy.component.css']
})
export class ToyComponent implements OnInit {

  toyArray:Toy[] = [];
  service:ToyService;

  //Inject and initialise ToyService into contructor to allow access with backend
  constructor(service:ToyService) {
    this.service = service;
   }

  ngOnInit(): void {
    this.getToys();
  }

    //Use toy service to access backend, and retrieve all products
  getToys(){
    let x = this.service.getAllToys();
    x. subscribe((response)=>{this.toyArray = response;
    })
  }

}

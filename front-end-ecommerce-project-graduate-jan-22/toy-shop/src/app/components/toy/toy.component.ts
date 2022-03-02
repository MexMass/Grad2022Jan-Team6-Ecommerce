import { Component, OnInit } from '@angular/core';
import { ToyService } from 'src/app/services/toy.service';
import { Toy } from '../../model/toy';

@Component({
  selector: 'app-toy',
  templateUrl: './toy.component.html',
  styleUrls: ['./toy.component.css']
})
export class ToyComponent implements OnInit {

  postId: string='';
  postTag: string='';
  toyArray:Toy[] = [];
  service:ToyService;

  constructor(service:ToyService) {
    this.service = service;
   }

  ngOnInit(): void {
    let x = this.service.getAllToys();
    x. subscribe((response)=>{this.toyArray = response;
    })
  }

  //method to get toys by id
  getToyById(){
    let x = this.service.getToyById(this.postId);
    x. subscribe((response)=>{this.toyArray = response;
    })
  }

  //method to gey toys by tag
  getToyByTag(){
    let x = this.service.getToyByTag(this.postTag);
    x. subscribe((response)=>{this.toyArray = response;
    })
  }

}

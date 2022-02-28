import { Component, OnInit } from '@angular/core';
import { ToyService } from 'src/app/services/toy.service';

@Component({
  selector: 'app-toy',
  templateUrl: './toy.component.html',
  styleUrls: ['./toy.component.css']
})
export class ToyComponent implements OnInit {

  service:ToyService;
  constructor(service:ToyService) {
    this.service = service;
   }

  ngOnInit(): void {
    let x = this.service.getAllToys();
    x. subscribe((response)=>{console.log(response);
    })
  }

}

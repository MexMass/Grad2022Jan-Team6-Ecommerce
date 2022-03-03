import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Toy } from 'src/app/model/toy';
import { ToyService } from 'src/app/services/toy.service';

@Component({
  selector: 'app-toy-details',
  templateUrl: './toy-details.component.html',
  styleUrls: ['./toy-details.component.css']
})
export class ToyDetailsComponent implements OnInit {

  service:ToyService;
  activeroute: ActivatedRoute;
  postId:any;
  toy:Toy[]=[];

  constructor(activeroute:ActivatedRoute,service:ToyService) {
    this.service=service; 
    this.activeroute = activeroute;
  }
    

  ngOnInit(): void {
    this.postId = this.activeroute.snapshot.paramMap.get('id');
    this.getToyById();
    console.log(this.toy);
    
    
  }

  //method to get toys by id
  getToyById(){
    let x = this.service.getToyById(this.postId);
    x. subscribe((response)=>{this.toy = response;
    })
  }

}

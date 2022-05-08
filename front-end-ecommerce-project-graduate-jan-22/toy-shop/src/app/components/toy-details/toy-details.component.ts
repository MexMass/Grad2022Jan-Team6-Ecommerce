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
  toy:Toy = {
    id: 0,
    name: '',
    supplier_name: '',
    units_in_stock: 0,
    total_price: 0,
    discontinued: false,
    image_url: ''
  };

  //Inject and initialise ToyService into contructor to allow access with backend
  constructor(activeroute:ActivatedRoute,service:ToyService) {
    this.service=service; 
    this.activeroute = activeroute;
  }
    

  ngOnInit(): void {
    //get toy id from route snapshot
    this.postId = this.activeroute.snapshot.paramMap.get('id');
    //uses id to get the details of the product
    this.getToyById();
    
  }

  //Use toy service to access backend, and retrieve the products by their id
  getToyById(){
    let x = this.service.getToyById(this.postId);
    x. subscribe((response)=>{this.toy = response;
    })
  }

}

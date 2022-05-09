import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Discount } from 'src/app/model/discount';
import { Toy } from 'src/app/model/toy';
import { DiscountService } from 'src/app/services/discount.service';
import { ToyService } from 'src/app/services/toy.service';

@Component({
  selector: 'app-toy-details',
  templateUrl: './toy-details.component.html',
  styleUrls: ['./toy-details.component.css']
})
export class ToyDetailsComponent implements OnInit {

  toyService:ToyService;
  discountService:DiscountService;
  activeroute: ActivatedRoute;
  postId:any;
  toy:Toy = { // initialize toy
    id: 0,
    name: '',
    supplier_name: '',
    units_in_stock: 0,
    total_price: 0,
    discontinued: false,
    image_url: ''
  };
  discount:Discount = {
    id: 0,
    product_id: 0,
    percent: 0
  };

  discountPrice:number = 0;

  myresponse : String = ''; // storage of response from back-end

  //Inject and initialise ToyService into contructor to allow access with backend
  constructor(activeroute:ActivatedRoute,toyService:ToyService, discountService:DiscountService) {
    this.toyService=toyService; 
    this.discountService = discountService;
    this.activeroute = activeroute;
  }
    

  ngOnInit(): void {
    //get toy id from route snapshot
    this.postId = this.activeroute.snapshot.paramMap.get('id');
    //uses id to get the details of the product
    

    this.getDiscount();
    console.log(this.discount);
    
    this.getToyById();
    console.log(this.toy);
  }

  //Use toy service to access backend, and retrieve the products by their id
  getToyById(){
    let x = this.toyService.getToyById(this.postId);
    x.subscribe((response)=>{this.toy = response;
    })
  }

  getDiscount(){
    let x =this.discountService.getDiscount(this.postId);
    x.subscribe((response)=>{this.discount = response;
    })
    this.getDiscountPrice();
  }

  getDiscountPrice(){
   this.toy.total_price=(this.discount.percent*this.toy.total_price)/10;
  }
  discontinueToy(){
    var result = confirm("Are you sure?");
    if (result) {
      let x = this.service.discontinueToy(this.toy.id);
      x.subscribe((response)=>{this.myresponse = response.response; // subscribe and wait for response. Store response
      })
    }
  }

}

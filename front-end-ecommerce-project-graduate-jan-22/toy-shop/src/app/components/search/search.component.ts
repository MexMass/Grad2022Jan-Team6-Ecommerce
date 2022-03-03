import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  route:Router;
  postTag:any;

  constructor(route:Router) { 
    this.route=route;
  }

  ngOnInit(): void {
  }

  //search button calls method on click
  //changes route to searched tag
  changeRoute(){
    this.route.navigate(['toys/tag', this.postTag])
  }

}

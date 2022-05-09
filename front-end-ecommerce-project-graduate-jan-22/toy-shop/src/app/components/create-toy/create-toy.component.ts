import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Toy } from 'src/app/model/toy';
import { ToyService } from 'src/app/services/toy.service';

@Component({
  selector: 'app-create-toy',
  templateUrl: './create-toy.component.html',
  styleUrls: ['./create-toy.component.css']
})
export class CreateToyComponent implements OnInit {

  createToyForm = this.formBuilder.group({  //create form using formBuilder. Assign validations using Validator
    name: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(25)]],
    supplier_name: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(25)]],
    units_in_stock: ['', [Validators.required, Validators.min(1)]],
    total_price: ['', [Validators.required, Validators.min(1)]],
    tags: [this.formBuilder.array([]),Validators.required],
    discontinued: [false],
    image_url: ['', Validators.required]
  })

  myresponse : String = ''; // storage of response from back-end

  constructor(
    private service: ToyService,
    private formBuilder: FormBuilder,
  ) { }

  ngOnInit(): void {
  }

  onSubmit(instance: Toy){ // get toy form values
    let x = this.service.createToy(instance) // call createToy function and pass form details
    x.subscribe((response)=>{this.myresponse = response.response; // subscribe and wait for response. Store response
  })
    
    this.createToyForm.reset() // reset form
  }
  
  // get functions for shortening the reference to values in the html
  get name() {
    return this.createToyForm.get('name');
  }
  get supplier_name() {
    return this.createToyForm.get('supplier_name');
  }
  get units_in_stock() {
    return this.createToyForm.get('units_in_stock');
  }
  get total_price() {
    return this.createToyForm.get('total_price');
  }
  get discontinued() {
    return this.createToyForm.get('discontinued');
  }
  get image_url() {
    return this.createToyForm.get('image_url');
  }
  get tags() {
    return this.createToyForm.get('tags');
  }
}

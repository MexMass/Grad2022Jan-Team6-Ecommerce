import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Toy } from 'src/app/model/toy';
import { ToyService } from 'src/app/services/toy.service';

@Component({
  selector: 'app-create-toy',
  templateUrl: './create-toy.component.html',
  styleUrls: ['./create-toy.component.css']
})
export class CreateToyComponent implements OnInit {

  createToyForm = this.formBuilder.group({
    name: '',
    supplier_name: '',
    units_in_stock: '',
    total_price: '',
    image_url: '',
  })

  constructor(
    private service: ToyService,
    private formBuilder: FormBuilder,
  ) { }

  ngOnInit(): void {
  }

  onSubmit(instance: Toy){
    let x = this.service.createToy(instance)
    x.subscribe((response)=>{console.log(response)
    })
    
    // console.warn('Your order has been submitted', this.createToyForm.value);
    this.createToyForm.reset()
  }

}

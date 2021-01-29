import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder, FormControl } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'jhi-add-restaurant',
  templateUrl: './add-restaurant.component.html',
  styleUrls: ['./add-restaurant.component.scss'],
})
export class AddRestaurantComponent implements OnInit {

  restaurantForm = this.fb.group({
    name: ['', Validators.required],
    cuisine: ['', Validators.required],
    bar: ['', Validators.required],
    specials: ['', Validators.required],
    location: ['', Validators.required],
    price: ['', Validators.required]
  })

  constructor(
    private http: HttpClient,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {}

  onSubmit() {
    console.warn(this.restaurantForm.value);
    this.http.post('http://localhost:9000/api/restaurant/add', this.restaurantForm.value).subscribe(
      (response) => console.log(response),
      (error) => console.log(error)
    );
  }

}

import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'jhi-add-restaurant',
  templateUrl: './add-restaurant.component.html',
  styleUrls: ['./add-restaurant.component.scss'],
})
export class AddRestaurantComponent implements OnInit {
  success = false;

  restaurantForm = this.fb.group({
    name: ['', Validators.required],
    cuisine: ['', Validators.required],
    bar: ['', Validators.required],
    specials: [''],
    location: ['', Validators.required],
    price: ['', Validators.required],
  });

  public response = {};
  public error = '';

  constructor(private http: HttpClient, private fb: FormBuilder) {}

  ngOnInit(): void {}

  onSubmit(): void {
    this.http.post('http://localhost:9000/api/restaurant/add', this.restaurantForm.value).subscribe(() => {
      this.success = true;
      this.restaurantForm.reset();
    });
  }
}

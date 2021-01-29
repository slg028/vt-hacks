import { Component } from '@angular/core';

@Component({
  selector: 'jhi-view-restaurants',
  templateUrl: './view-restaurants.component.html',
  styleUrls: ['./view-restaurants.component.scss'],
})
export class ViewRestaurantsComponent {
  columnDefs = [
    {
      headerName: 'Name',
      field: 'name',
      sortable: true,
      filter: true,
    },
    {
      headerName: 'Cuisine',
      field: 'cuisine',
      sortable: true,
      filter: true,
    },
    {
      headerName: 'Price',
      field: 'price',
      sortable: true,
      filter: 'agTextColumnFilter',
      filterParams: {
        defaultOption: 'equals',
      },
    },
    {
      headerName: 'Location',
      field: 'location',
      sortable: true,
      filter: true,
    },
    {
      headerName: 'Specials',
      field: 'specials',
      sortable: true,
      filter: true,
    },
    {
      headerName: 'Bar',
      field: 'bar',
      sortable: true,
      filter: true,
    },
  ];

  sortingOrder = ['asc', 'desc', null];

  rowData = [];

  // eslint-disable-next-line @typescript-eslint/tslint/config
  ngOnInit() {
    fetch('http://localhost:9000/api/restaurants')
      .then(result => result.json())
      .then(rowData => {
        rowData.forEach((restaurant: any, i: number) => {
          rowData[i].price = this.getDollarSigns(restaurant.price);
          rowData[i].bar = this.getIsBar(restaurant.bar);
          rowData[i].name = this.titleCase(restaurant.name);
          rowData[i].cuisine = this.titleCase(restaurant.cuisine);
          this.rowData = rowData;
        });
      });
  }

  public getDollarSigns(price: number): string {
    switch (price) {
      case 1:
        return '$';
      case 2:
        return '$$';
      case 3:
        return '$$$';
      default:
        return '';
    }
  }

  public getIsBar(bar: number): string {
    switch (bar) {
      case 0:
        return 'No';
      case 1:
        return 'Yes';
      default:
        return '';
    }
  }

  public titleCase(str: string): string {
    return str.toLowerCase().replace(/\b(\w)/g, s => s.toUpperCase());
  }
}

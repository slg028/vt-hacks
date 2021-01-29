import { NgModule } from '@angular/core';

import { AgGridModule } from 'ag-grid-angular';
import { ViewRestaurantsComponent } from './view-restaurants.component';

@NgModule({
  imports: [AgGridModule.withComponents([])],
  declarations: [ViewRestaurantsComponent],
})
export class ViewRestaurantsModule {}

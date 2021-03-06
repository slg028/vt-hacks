import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AgGridModule } from 'ag-grid-angular';

import './vendor';
import { VtFoodSharedModule } from 'app/shared/shared.module';
import { VtFoodCoreModule } from 'app/core/core.module';
import { VtFoodAppRoutingModule } from './app-routing.module';
import { VtFoodHomeModule } from './home/home.module';
import { VtFoodEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';
import { AddRestaurantComponent } from './add-restaurant/add-restaurant.component';
import { ViewRestaurantsModule } from './view-restaurants/view-restaurants.module';

@NgModule({
  imports: [
    AgGridModule.withComponents(null),
    BrowserModule,
    ViewRestaurantsModule,
    VtFoodSharedModule,
    VtFoodCoreModule,
    VtFoodHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    VtFoodEntityModule,
    VtFoodAppRoutingModule,
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent, AddRestaurantComponent],
  bootstrap: [MainComponent],
})
export class VtFoodAppModule {}

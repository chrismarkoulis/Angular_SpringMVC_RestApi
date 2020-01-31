import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {SalesmanComponent} from './salesman/salesman.component';
import { SalesmanService } from './salesman/salesman.service';
import { HttpModule } from '@angular/http';

@NgModule({
  declarations: [
    AppComponent, SalesmanComponent
  ],
  imports: [
    BrowserModule, HttpModule, FormsModule, 
    AppRoutingModule
  ],
  providers: [SalesmanService],
  bootstrap: [AppComponent]
})
export class AppModule { }

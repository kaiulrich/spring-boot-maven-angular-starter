import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { FormsModule }   from '@angular/forms';

import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';

import { environment } from './../environments/environment';
import { AppNavbarComponent } from './app-navbar/app-navbar.component';
import { UserdataComponent } from './userdata/userdata.component'; 

import { UserDataService } from './userdata.service'; 

@NgModule({
  declarations: [
    AppComponent,
    AppNavbarComponent,
    UserdataComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    NgbModule.forRoot()
  ],
  providers: [
    UserDataService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

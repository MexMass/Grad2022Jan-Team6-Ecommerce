import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ToyComponent } from './components/toy/toy.component';
import { ToyService } from './services/toy.service';

@NgModule({
  declarations: [
    AppComponent,
    ToyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [ToyService],
  bootstrap: [AppComponent]
})
export class AppModule { }

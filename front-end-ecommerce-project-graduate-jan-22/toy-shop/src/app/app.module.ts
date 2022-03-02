import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule , Routes} from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ToyComponent } from './components/toy/toy.component';
import { ToyService } from './services/toy.service';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { CreateToyComponent } from './components/create-toy/create-toy.component';

//http://localhost:4200/

const routes: Routes  = [
  //{path: 'home' , component: HomeComponent},
  // {path : 'login' , component :LoginComponent },
  {path : 'toys', component : ToyComponent},
  //{path: 'menu/:id/name/:name', component: ProductDetailComponent},
  //{path: '', redirectTo: '/home', pathMatch: 'full'},
  //{path: '**', component: PagenotfoundComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    ToyComponent,
    CreateToyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes),
    ReactiveFormsModule
  ],
  providers: [ToyService],
  bootstrap: [AppComponent]
})
export class AppModule { }

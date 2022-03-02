import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule , Routes} from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ToyComponent } from './components/toy/toy.component';
import { ToyService } from './services/toy.service';
import { FormsModule } from '@angular/forms';

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
    ToyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [ToyService],
  bootstrap: [AppComponent]
})
export class AppModule { }

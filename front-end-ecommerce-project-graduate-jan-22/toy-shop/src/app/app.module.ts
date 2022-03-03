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
import { ToyDetailsComponent } from './components/toy-details/toy-details.component';
import { TagComponent } from './components/tag/tag.component';
import { SearchComponent } from './components/search/search.component';

//http://localhost:4200/

const routes: Routes  = [
  //{path: 'home' , component: HomeComponent},
  {path : 'toys/tag/:tag' , component :TagComponent },
  {path : 'toys/create' , component :CreateToyComponent},
  {path : 'toys', component : ToyComponent},
  {path: 'toys/:id', component: ToyDetailsComponent},
  //{path: '', redirectTo: '/home', pathMatch: 'full'},
  //{path: '**', component: PagenotfoundComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    ToyComponent,
    CreateToyComponent,
    ToyDetailsComponent,
    TagComponent,
    SearchComponent
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

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { EstacionamientoComponent } from './componentes/estacionamiento/estacionamiento.component';
import {PanelModule} from 'primeng/panel';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {DropdownModule} from 'primeng/dropdown';
import { FormsModule } from '@angular/forms';
import {TableModule} from 'primeng/table';
import {MessagesModule} from 'primeng/messages';
import {MessageModule} from 'primeng/message';
import { HttpClientModule } from '../../node_modules/@angular/common/http';
const routes: Routes = [
  { path: 'estacionamiento', component: EstacionamientoComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    EstacionamientoComponent
  ],
  imports: [
    BrowserModule,RouterModule.forRoot(routes),PanelModule,BrowserAnimationsModule,
    DropdownModule,FormsModule,TableModule,MessagesModule,MessageModule,HttpClientModule 
  ],
  exports: [RouterModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

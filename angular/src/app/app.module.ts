import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { EstacionamientoComponent } from './componentes/estacionamiento/estacionamiento.component';
import {PanelModule} from 'primeng/panel';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {DropdownModule} from 'primeng/dropdown';
import { FormsModule } from '@angular/forms';
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
    DropdownModule,FormsModule
  ],
  exports: [RouterModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

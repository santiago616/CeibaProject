import { Component, OnInit } from '@angular/core';
import {SelectItem} from 'primeng/api';

@Component({
  selector: 'app-estacionamiento',
  templateUrl: './estacionamiento.component.html',
  styleUrls: ['./estacionamiento.component.css']
})
export class EstacionamientoComponent implements OnInit {
 
  tiposVehiculo:SelectItem[];
  selectTipoVehiculo:String;
  constructor() {
    this.tiposVehiculo=[{label:'Seleccione el tipo de vehiculo',value:''},
    {label:'Auto',value:'AUTO'},
    {label:'Moto',value:'MOTO'}
   ]
  }

  ngOnInit() {
  }

}

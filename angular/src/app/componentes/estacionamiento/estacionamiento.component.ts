import { Component, OnInit } from '@angular/core';
import { SelectItem } from 'primeng/api';
import { Message } from 'primeng/components/common/api';
import { MessageService } from 'primeng/components/common/messageservice';
import { Registro } from '../../model/registro';
import { EstacionamientoServiceService } from '../estacionamiento-service.service';


@Component({
  selector: 'app-estacionamiento',
  templateUrl: './estacionamiento.component.html',
  styleUrls: ['./estacionamiento.component.css'],
  providers: [MessageService, EstacionamientoServiceService]
})
export class EstacionamientoComponent implements OnInit {
  msgs: Message[] = [];
  tiposVehiculo: SelectItem[];
  selectTipoVehiculo: String;
  registros: Registro[] = [];
  placa: string;
  registroNuevo: Registro;
  disabled:boolean=true;
  constructor(private messageService: MessageService, private registroService: EstacionamientoServiceService) {
    this.tiposVehiculo = [{ label: 'Seleccione el tipo de vehiculo', value: '' },
    { label: 'Auto', value: 'AUTO' },
    { label: 'Moto', value: 'MOTO' }
    ]
    this.registroNuevo = new Registro();
  }

  ngOnInit() {
  }

  obtenerRegistroPorPlaca() {
    let resultado
    this.placa = this.placa.toUpperCase();
    this.registros=[];
    this.registroService.getRegistroPlaca(this.placa).subscribe(registros => {
      if(registros!=undefined){
      resultado = registros;
      if (resultado.facturado == true) {
        resultado.facturado = 'SI';
      } else {
        resultado.facturado = 'NO';
      }

      this.registros.push(resultado)
      if (resultado != null) {
        this.showSuccess('Registro consultado correctamente')
      }
    }else{
      this.showError('No se ha podido obtener el registro')
    }
    });

  }

  agregarRegistro() {
    let resultado;
    this.registroNuevo.horaEntrada = new Date();
    this.registroNuevo.placa = this.registroNuevo.placa.toUpperCase();
    this.registroService.addRegistro(this.registroNuevo).subscribe((response) => {
      if(response!=null){
        this.showSuccess('Registro creado exitosamente');
      }else{
       // this.showError(response.headers.get('errores-estacionamiento'));
       this.showError('No se ha podido crear el registro');
      }
    });

  }

  facturarRegistro() {
    let resultado;
    this.registroService.updateRegistro(this.registros[0].placa).subscribe((response) => {
      if(response!=null){
        this.registros=[];
        resultado=response;
        if (resultado.facturado == true) {
          resultado.facturado = 'SI';
        } else {
          resultado.facturado = 'NO';
        }
        this.registros.push(resultado);
        this.showSuccess('Registro facturado exitosamente');
      }else{
       // this.showError(response.headers.get('errores-estacionamiento'));
       this.showError('No se ha facturar el registro');
      }
    });

  }


  showSuccess(mensaje: string) {
    this.msgs = [];
    this.msgs.push({ severity: 'success', summary: 'Mensaje de exito', detail: mensaje });
  }

  showInfo(mensaje: string) {
    this.msgs = [];
    this.msgs.push({ severity: 'info', summary: 'Mensaje de informacion', detail: mensaje });
  }


  showError(mensaje: string) {
    this.msgs = [];
    this.msgs.push({ severity: 'error', summary: 'Mensaje de error', detail: mensaje });
  }
}

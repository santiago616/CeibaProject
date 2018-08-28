import { Vehiculo } from "./vehiculo";

export class Registro{

    public id:number;
    public vehiculo:Vehiculo;
    public horaEntrada:Date;
    public horaSalida:Date;
    public tiempoTotal:number[];
    public facturado:boolean;
    public valorTotal:number;

    constructor(){
    }
}
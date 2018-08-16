package com.ceiba.estacionamiento.estacionamiento.dominio;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import com.ceiba.estacionamiento.estacionamiento.dto.RegistroDTO;

public class Registro {
	
	public static final int TOTAL_DISPONIBILIDAD_AUTOS=20;
	
	public static final int TOTAL_DISPONIBILIDAD_MOTOS=20;
	
	public static final BigDecimal VALOR_HORA_CARRO=new BigDecimal(1000);
	
	public static final BigDecimal VALOR_HORA_MOTO=new BigDecimal(500);
	
	public static final BigDecimal VALOR_DIA_CARRO=new BigDecimal(8000);
	
	public static final BigDecimal VALOR_DIA_MOTO=new BigDecimal(400);
	
	public static final int LIMITE_CILINDRAJE=500;
	
	public static final BigDecimal VALOR_LIMITE_CILINDRAJE=new BigDecimal(2000);
	
	public static final int TIEMPO_MAXIMO_HORAS=9;
	
	public static final int TIEMPO_MAXIMO_DIA=24;
	
	public static final String RESTRICION_PLACA="A";
	
	public boolean disponibilidadAutos() {
		return Boolean.FALSE;
	}
	
	public boolean disponibilidadMotos() {
		return Boolean.FALSE;
	}
	
	public boolean validarIngresoPlaca() {
		return Boolean.FALSE;
	}
	public BigDecimal calcularValorParqueadero(RegistroDTO registroVigilante) {
		BigDecimal valor = new BigDecimal(100);
		return valor;
	}
	
	public double calcularTiempoParqueado(RegistroDTO registroVigilante) {
		Long diffInMillies = Math.abs(registroVigilante.getHoraSalida().getTime() - registroVigilante.getHoraEntrada().getTime());
	    Long diff = TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);
	    
	    int dias=0;
	    int horas=0;
	    
	    if(diff<TIEMPO_MAXIMO_HORAS) {
	    	horas=diff.intValue();
	    }else {
	    	dias++;
	    	if(diff>TIEMPO_MAXIMO_DIA) {
	    		int horasAdicionales=diff.intValue()%TIEMPO_MAXIMO_DIA;
	    		dias+=Math.floorDiv(diff.intValue(), TIEMPO_MAXIMO_DIA);
	    		if(horasAdicionales<TIEMPO_MAXIMO_HORAS) {
	    			horas+=horasAdicionales;
	    		}else {
	    			dias++;
	    		}
	    	}
	    }
		
		return 2;
	}
	
	public BigDecimal calcularTarifaCilindraje(RegistroDTO registroVigilante) {
		BigDecimal tarifa = new BigDecimal(100);
		return tarifa;
	}
	
	

}

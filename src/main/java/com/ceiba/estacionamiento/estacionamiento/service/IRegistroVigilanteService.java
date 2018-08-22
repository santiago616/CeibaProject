package com.ceiba.estacionamiento.estacionamiento.service;
import com.ceiba.estacionamiento.estacionamiento.dto.RegistroDTO;

public interface IRegistroVigilanteService {
	
	public void almacenarRegistro(RegistroDTO registroVigilante);
	
	public void facturarVehiculo(String placa);
	
	public RegistroDTO consultarVehiculoPorPlaca(String placa);
	
	public void actualizarRegistroFacturado(RegistroDTO registroVigilante);
	
	public Boolean validarIngresoVehiculo(RegistroDTO registroVigilanteDTO);

}

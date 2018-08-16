package com.ceiba.estacionamiento.estacionamiento.service;
import com.ceiba.estacionamiento.estacionamiento.dto.RegistroDTO;

public interface IRegistroVigilanteService {
	
	public void almacenarRegistro(RegistroDTO registroVigilante);
	
	public void facturarVehiculo(RegistroDTO registroVigilanteDTO);
	
	public RegistroDTO consultarVehiculoPorPlaca(String placa);
	
	public void actualizarRegistroFacturado(RegistroDTO registroVigilante);
	
	public boolean validarIngresoVehiculo(String tipoVehiculo,String placa);

}

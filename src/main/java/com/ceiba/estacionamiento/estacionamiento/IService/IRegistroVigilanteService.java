package com.ceiba.estacionamiento.estacionamiento.IService;

import org.hibernate.annotations.Loader;

import com.ceiba.estacionamiento.estacionamiento.dto.RegistroVigilanteDTO;

public interface IRegistroVigilanteService {
	
	public void almacenarRegistro(RegistroVigilanteDTO registroVigilante);
	
	public void facturarVehiculo(RegistroVigilanteDTO registroVigilanteDTO);
	
	public RegistroVigilanteDTO consultarVehiculoPorId(Long id);
	
	public void actualizarRegistroFacturado(RegistroVigilanteDTO registroVigilante);

}

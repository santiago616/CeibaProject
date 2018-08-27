package com.ceiba.estacionamiento.estacionamiento.service;
import java.util.List;

import com.ceiba.estacionamiento.estacionamiento.dto.ParametrizacionDTO;
import com.ceiba.estacionamiento.estacionamiento.dto.RegistroDTO;

public interface IRegistroVigilanteService {
	
	public RegistroDTO almacenarRegistro(RegistroDTO registroVigilante);
	
	public RegistroDTO facturarVehiculo(String placa);
	
	public RegistroDTO consultarVehiculoPorPlaca(String placa);
	
	public RegistroDTO actualizarRegistroFacturado(RegistroDTO registroVigilante);
	
	public Boolean validarIngresoVehiculo(RegistroDTO registroVigilanteDTO);
	
	public List<String> getListaErrores();

	ParametrizacionDTO consultarParametrosTipoVehiculo(String tipoVehiculo);

}

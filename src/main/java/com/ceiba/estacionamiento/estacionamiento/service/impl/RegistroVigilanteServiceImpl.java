package com.ceiba.estacionamiento.estacionamiento.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.estacionamiento.estacionamiento.dominio.Estacionamiento;
import com.ceiba.estacionamiento.estacionamiento.dto.ParametrizacionDTO;
import com.ceiba.estacionamiento.estacionamiento.dto.RegistroDTO;
import com.ceiba.estacionamiento.estacionamiento.entity.ParametrizacionEntity;
import com.ceiba.estacionamiento.estacionamiento.entity.RegistroEntity;
import com.ceiba.estacionamiento.estacionamiento.repository.ParametrizacionRepository;
import com.ceiba.estacionamiento.estacionamiento.repository.RegistroVigilanteRepository;
import com.ceiba.estacionamiento.estacionamiento.service.IEstacionamientoService;
import com.ceiba.estacionamiento.estacionamiento.service.IRegistroVigilanteService;

@Service
public class RegistroVigilanteServiceImpl implements IRegistroVigilanteService {

	RegistroVigilanteRepository registroVigilanteRepository;
	
	ParametrizacionRepository parametrizacionRepository;

	IEstacionamientoService estacionamientoService;

	Estacionamiento registroEstacionamiento = new Estacionamiento();

	private final ModelMapper modelMapper = new ModelMapper();
	
	private List<String> listaErrores;

	@Autowired
	public RegistroVigilanteServiceImpl(RegistroVigilanteRepository registroVigilanteRepository,
			IEstacionamientoService estacionamientoService,ParametrizacionRepository parametrizacionRepository) {
		this.registroVigilanteRepository = registroVigilanteRepository;
		this.estacionamientoService = estacionamientoService;
		this.parametrizacionRepository=parametrizacionRepository;
	}

	@Override
	@Transactional
	public RegistroDTO almacenarRegistro(RegistroDTO registroVigilanteDTO) {
		RegistroDTO registroResult=new RegistroDTO();
			if (validarIngresoVehiculo(registroVigilanteDTO)) {
				if(registroVigilanteDTO.getHoraEntrada()==null) {
					registroVigilanteDTO.setHoraEntrada(new Date());
				}
				registroVigilanteDTO.setFacturado(Boolean.FALSE);
				RegistroEntity registroVigilante = modelMapper.map(registroVigilanteDTO, RegistroEntity.class);
				return   modelMapper.map(registroVigilanteRepository.save(registroVigilante),RegistroDTO.class);

			} 
		return registroResult;
	}

	@Override
	@Transactional
	public RegistroDTO facturarVehiculo(String placa) {
		RegistroDTO registroVigilanteDTO;
		registroVigilanteDTO=consultarVehiculoPorPlaca(placa);
		if (registroVigilanteDTO.getId() != null) {
			registroVigilanteDTO.setHoraSalida(new Date());
			int[] tiempoTotal=registroEstacionamiento.calcularTiempoParqueado(registroVigilanteDTO);
			registroVigilanteDTO.setTiempoTotal(tiempoTotal);
			ParametrizacionDTO parametrizacion=consultarParametrosTipoVehiculo(registroVigilanteDTO.getVehiculo().getTipoVehiculo());
			BigDecimal tarifaTotalPorVehiculo = registroEstacionamiento.calcularValorParqueadero(registroVigilanteDTO,parametrizacion);
			registroVigilanteDTO.setTotalServicio(tarifaTotalPorVehiculo);
			registroVigilanteDTO.setFacturado(Boolean.TRUE);
			return actualizarRegistroFacturado(registroVigilanteDTO);
			
		}
		return registroVigilanteDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public RegistroDTO consultarVehiculoPorPlaca(String placa) {
		RegistroDTO registroResult=new RegistroDTO();
		if (placa != null) {
			RegistroEntity registroVigilante = registroVigilanteRepository.buscarRegistroPorPlaca(placa);
			if (registroVigilante != null) {
				
				registroResult=modelMapper.map(registroVigilante, RegistroDTO.class);
				return registroResult;
			}
		}
		return registroResult;
	}

	@Override
	@Transactional
	public RegistroDTO actualizarRegistroFacturado(RegistroDTO registroVigilanteDTO) {
		RegistroDTO registroResult=new RegistroDTO();
		if (registroVigilanteDTO.getId() != null) {
			RegistroEntity registroVigilante = modelMapper.map(registroVigilanteDTO, RegistroEntity.class);
			registroResult=modelMapper.map(registroVigilanteRepository.save(registroVigilante),RegistroDTO.class);
			return registroResult;
		}
		return registroResult;

	}

	@Override
	public Boolean validarIngresoVehiculo(RegistroDTO registroVigilanteDTO) {
		RegistroDTO vehiculoExistente = consultarVehiculoPorPlaca(registroVigilanteDTO.getVehiculo().getPlaca());
		listaErrores=new ArrayList<>();
		if(vehiculoExistente.getId()!=null) {
			listaErrores.add("El vehiculo ya se encuentra registrado o la placa es invalida");
		}
		Boolean existenCuposDisponibles = estacionamientoService.validarCuposEstacionamiento(registroVigilanteDTO.getVehiculo().getTipoVehiculo());
		if(!existenCuposDisponibles) {
			listaErrores.add("No existen cupos disponibles para este tipo de vehiculo.");
		}
		Boolean placaValida = estacionamientoService.validarPlacaVehiculo(registroVigilanteDTO);
		if(!placaValida) {
			listaErrores.add("El vehiculo no se encuentra autorizado para ingresar.");
		}
		return (listaErrores.isEmpty());
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public ParametrizacionDTO consultarParametrosTipoVehiculo(String tipoVehiculo) {
		ParametrizacionDTO parametrizacion=new ParametrizacionDTO();
		if (tipoVehiculo != null) {
			ParametrizacionEntity parametros = parametrizacionRepository.buscarParametrizacionPorTipoVehiculo(tipoVehiculo);
			if (parametros != null) {
				parametrizacion=modelMapper.map(parametros, ParametrizacionDTO.class);
				return parametrizacion;
			}
		}
		return parametrizacion;
	}
	

	public List<String> getListaErrores() {
		return listaErrores;
	}

	public void setListaErrores(List<String> listaErrores) {
		this.listaErrores = listaErrores;
	}


}

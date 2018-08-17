package com.ceiba.estacionamiento.estacionamiento.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.estacionamiento.estacionamiento.dominio.Registro;
import com.ceiba.estacionamiento.estacionamiento.dto.RegistroDTO;
import com.ceiba.estacionamiento.estacionamiento.entity.RegistroEntity;
import com.ceiba.estacionamiento.estacionamiento.repository.RegistroVigilanteRepository;
import com.ceiba.estacionamiento.estacionamiento.service.IParqueaderoService;
import com.ceiba.estacionamiento.estacionamiento.service.IRegistroVigilanteService;

@Service
public class RegistroVigilanteServiceImpl implements IRegistroVigilanteService {

	RegistroVigilanteRepository registroVigilanteRepository;

	IParqueaderoService parqueaderoService;

	Registro registroParqueadero = new Registro();

	private final ModelMapper modelMapper = new ModelMapper();

	@Autowired
	public RegistroVigilanteServiceImpl(RegistroVigilanteRepository registroVigilanteRepository,
			IParqueaderoService parqueaderoService) {
		this.registroVigilanteRepository = registroVigilanteRepository;
		this.parqueaderoService = parqueaderoService;
	}

	@Override
	@Transactional
	public void almacenarRegistro(RegistroDTO registroVigilanteDTO) {
		RegistroDTO vehiculoExistente = consultarVehiculoPorPlaca(registroVigilanteDTO.getPlaca());
		
			if (vehiculoExistente == null
					&& validarIngresoVehiculo(registroVigilanteDTO.getTipoVehiculo(), registroVigilanteDTO.getPlaca())) {
				registroVigilanteDTO.setHoraEntrada(new Date());
				registroVigilanteDTO.setFacturado(Boolean.FALSE);
				RegistroEntity registroVigilante = modelMapper.map(registroVigilanteDTO, RegistroEntity.class);
				registroVigilanteRepository.save(registroVigilante);

			} else {
				// EL AUTO YA ESTA ALMACENADO
			}
		
	}

	@Override
	@Transactional
	public void facturarVehiculo(String placa) {
		RegistroDTO registroVigilanteDTO=consultarVehiculoPorPlaca(placa);
		if (registroVigilanteDTO != null) {
			registroVigilanteDTO.setHoraSalida(new Date());
			registroVigilanteDTO.getHoraSalida();
			registroVigilanteDTO.getHoraSalida().setHours(21);
			BigDecimal tarifaTotalPorVehiculo = registroParqueadero.calcularValorParqueadero(registroVigilanteDTO);
			registroVigilanteDTO.setTotalServicio(tarifaTotalPorVehiculo);
			registroVigilanteDTO.setFacturado(Boolean.TRUE);
			actualizarRegistroFacturado(registroVigilanteDTO);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public RegistroDTO consultarVehiculoPorPlaca(String placa) {
		if (placa != null) {
			RegistroEntity registroVigilante = registroVigilanteRepository.buscarRegistroPorPlaca(placa);
			if (registroVigilante != null) {
				
				return modelMapper.map(registroVigilante, RegistroDTO.class);
			}
		}
		return null;
	}

	@Override
	@Transactional
	public void actualizarRegistroFacturado(RegistroDTO registroVigilanteDTO) {
		if (registroVigilanteDTO.getId() != null) {
			RegistroEntity registroVigilante = modelMapper.map(registroVigilanteDTO, RegistroEntity.class);
			registroVigilanteRepository.save(registroVigilante);
			registroVigilanteRepository.flush();
		}

	}

	@Override
	public Boolean validarIngresoVehiculo(String tipoVehiculo, String placa) {
		Boolean existenCuposDisponibles = parqueaderoService.validarCuposParqueadero(tipoVehiculo);
		Boolean placaValida = parqueaderoService.validarPlacaVehiculo(placa);
		return (existenCuposDisponibles && placaValida);
	}

}

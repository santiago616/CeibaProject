package com.ceiba.estacionamiento.estacionamiento.dominio;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import com.ceiba.estacionamiento.estacionamiento.dto.ParametrizacionDTO;
import com.ceiba.estacionamiento.estacionamiento.dto.RegistroDTO;

public class Estacionamiento {

	public static final int TOTAL_DISPONIBILIDAD_AUTOS = 20;

	public static final int TOTAL_DISPONIBILIDAD_MOTOS = 20;

	public static final BigDecimal VALOR_HORA_CARRO = new BigDecimal(1000);

	public static final BigDecimal VALOR_HORA_MOTO = new BigDecimal(500);

	public static final BigDecimal VALOR_DIA_CARRO = new BigDecimal(8000);

	public static final BigDecimal VALOR_DIA_MOTO = new BigDecimal(4000);

	public static final int LIMITE_CILINDRAJE = 500;

	public static final BigDecimal VALOR_LIMITE_CILINDRAJE = new BigDecimal(2000);

	public static final int TIEMPO_MAXIMO_HORAS = 9;

	public static final int TIEMPO_MAXIMO_DIA = 24;

	public static final String RESTRICION_PLACA = "A";

	public static final String MOTO = "MOTO";

	public static final String AUTO = "AUTO";

	public BigDecimal calcularValorParqueadero(RegistroDTO registroVigilante, ParametrizacionDTO parametrizacion) {

		return calcularTarifaTipoVehiculo(registroVigilante, calcularTiempoParqueado(registroVigilante),
				parametrizacion);
	}

	public int[] calcularTiempoParqueado(RegistroDTO registroVigilante) {
		Long diffInMillies = Math
				.abs(registroVigilante.getHoraSalida().getTime() - registroVigilante.getHoraEntrada().getTime());
		Long diff = TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		int[] tiempoTotal = new int[2];
		int dias = 0;
		int horas = 0;

		if (diff < TIEMPO_MAXIMO_HORAS) {
			horas = diff.intValue();
		} else {
			dias++;
			if (diff > TIEMPO_MAXIMO_DIA) {
				int horasAdicionales = diff.intValue() % TIEMPO_MAXIMO_DIA;
				dias = 0;
				dias += Math.floorDiv(diff.intValue(), TIEMPO_MAXIMO_DIA);
				if (horasAdicionales < TIEMPO_MAXIMO_HORAS) {
					horas += horasAdicionales;
				} else {
					dias++;
				}
			}
		}

		tiempoTotal[0] = dias;
		tiempoTotal[1] = horas;
		return tiempoTotal;
	}

	public BigDecimal calcularTarifaTipoVehiculo(RegistroDTO registroVigilante, int[] tiempoTotal,
			ParametrizacionDTO parametrizacion) {
		BigDecimal totalTarifa = new BigDecimal(0);
		if (registroVigilante.getVehiculo().getTipoVehiculo().equalsIgnoreCase(parametrizacion.getTipoVehiculo())) {
			totalTarifa = parametrizacion.getValorDiaVehiculo().multiply(BigDecimal.valueOf(tiempoTotal[0]))
					.add(parametrizacion.getValorHoraVehiculo().multiply(BigDecimal.valueOf(tiempoTotal[1])));
		}
		if (registroVigilante.getVehiculo() != null
				&& registroVigilante.getVehiculo().getCilindraje() > LIMITE_CILINDRAJE) {

			totalTarifa = totalTarifa.add(VALOR_LIMITE_CILINDRAJE);
		}

		return totalTarifa;
	}

	public Boolean validarDisponiblidadCupos(Long cuposUsados, String tipo) {

		if (tipo.equalsIgnoreCase(AUTO) && cuposUsados < TOTAL_DISPONIBILIDAD_AUTOS) {
			return Boolean.TRUE;
		} else {
			if (tipo.equalsIgnoreCase(MOTO) && cuposUsados < TOTAL_DISPONIBILIDAD_MOTOS) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	public Boolean validarPlacaDomingoLunes(RegistroDTO registroVigilanteDTO) {
		Boolean puedeIngresar = Boolean.TRUE;
		Calendar hoy = Calendar.getInstance();
		hoy.setTime(registroVigilanteDTO.getHoraEntrada());
		if (registroVigilanteDTO.getVehiculo().getPlaca().substring(0, 1).equals(RESTRICION_PLACA)) {
			if (hoy.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || hoy.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
				puedeIngresar = Boolean.TRUE;
			} else {
				puedeIngresar = Boolean.FALSE;
			}
		}
		return puedeIngresar;
	}

}

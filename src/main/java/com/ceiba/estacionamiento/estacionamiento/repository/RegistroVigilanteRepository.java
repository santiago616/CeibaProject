package com.ceiba.estacionamiento.estacionamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ceiba.estacionamiento.estacionamiento.entity.RegistroEntity;
import com.ceiba.estacionamiento.estacionamiento.entity.VehiculoEntity;

public interface RegistroVigilanteRepository  extends JpaRepository<RegistroEntity, Long>{

	
//	@Query(value =  "	SELECT r"
//			+ "	FROM registro r "
//			+ "	WHERE r.facturado = true and UPPER(r.placa) LIKE UPPER(':placa')")
	@Query(value =  "	SELECT r from registro r where r.facturado = false and UPPER(r.vehiculo.placa) like (:placa)")
	RegistroEntity buscarRegistroPorPlaca(@Param("placa") String placa);
	
	@Query(value =  "	SELECT count(r.id)"
			+ "	FROM registro r "
			+ "	WHERE r.facturado = false and UPPER(r.vehiculo.tipoVehiculo) LIKE UPPER(:tipoVehiculo)")
	Long buscarRegistrosPorTipoVehiculo(@Param("tipoVehiculo")String tipoVehiculo);
	
	
	@Query(value =  "	SELECT v from vehiculo v where UPPER(v.placa) like (:placa)")
	VehiculoEntity buscarVehiculoPorPlaca(@Param("placa") String placa);
	
}

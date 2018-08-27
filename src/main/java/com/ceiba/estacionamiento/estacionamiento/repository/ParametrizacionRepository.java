package com.ceiba.estacionamiento.estacionamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ceiba.estacionamiento.estacionamiento.entity.ParametrizacionEntity;

public interface ParametrizacionRepository extends JpaRepository<ParametrizacionEntity, Long> {
	
	@Query("select p from parametrizacion p where UPPER(p.tipoVehiculo) LIKE UPPER(:tipoV)")
	ParametrizacionEntity buscarParametrizacionPorTipoVehiculo(@Param ("tipoV") String tipoVehiculo);

}

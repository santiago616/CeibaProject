package com.ceiba.estacionamiento.estacionamiento.dto;

public class ParqueaderoDTO {
	
	private Long id;
	
	private String nombre;
	
	private Long telefono;
	
	private String direccion;

	public ParqueaderoDTO(Long id, String nombre, Long telefono, String direccion) {
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public ParqueaderoDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "ParqueaderoDTO [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion
				+ "]";
	}
	
	
	

}

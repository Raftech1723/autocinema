package com.sala.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sala")
public class Sala {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "capacidad")
    private Integer capacidad;
    @Column(name = "sede_id")
    private Integer sede_id;
	
    public Sala() {
		super();
	}

	public Sala(Long id, String nombre, Integer capacidad, Integer sede_id) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.sede_id = sede_id;
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

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public Integer getSede_id() {
		return sede_id;
	}

	public void setSede_id(Integer sede_id) {
		this.sede_id = sede_id;
	}

	@Override
	public String toString() {
		return "Sala [id=" + id + ", nombre=" + nombre + ", capacidad=" + capacidad + ", sede_id=" + sede_id + "]";
	}
    
    
}

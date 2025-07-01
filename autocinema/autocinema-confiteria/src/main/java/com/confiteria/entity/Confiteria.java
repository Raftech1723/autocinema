package com.confiteria.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "confiteria")
public class Confiteria {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "precio")
    private Double precio;
    @Column(name = "descripcion")
    private String descripcion;
	
    public Confiteria() {
		super();
	}

	public Confiteria(Long id, String nombre, Double precio, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Confiteria [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descripcion=" + descripcion
				+ "]";
	}
    
    
}

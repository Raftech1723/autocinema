package com.funciones.entity;

import java.time.LocalTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="funciones")
public class Funciones {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	
	@Column(name = "fecha")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	
	
	@Column(name = "hora")
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime hora;

	@Column(name = "pelicula_id")
	private Integer pelicula_id;
	
	@Column(name = "sala_id")
	private Integer sala_id;

	public Funciones() {
		super();
	}

	public Funciones(Long id, Date fecha, LocalTime hora, Integer pelicula_id, Integer sala_id) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.pelicula_id = pelicula_id;
		this.sala_id = sala_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public Integer getPelicula_id() {
		return pelicula_id;
	}

	public void setPelicula_id(Integer pelicula_id) {
		this.pelicula_id = pelicula_id;
	}

	public Integer getSala_id() {
		return sala_id;
	}

	public void setSala_id(Integer sala_id) {
		this.sala_id = sala_id;
	}

	@Override
	public String toString() {
		return "Funciones [id=" + id + ", pelicula_id=" + pelicula_id + ", sala_id=" + sala_id + "]";
	}
	
	
}

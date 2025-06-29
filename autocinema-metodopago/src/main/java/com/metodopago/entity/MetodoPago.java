package com.metodopago.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "metodo_pago")
public class MetodoPago {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id")
    private Long id;
    
    @Column(name = "metodo")
    private String metodo;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "activo")
    private Boolean activo;
    
    @Column(name = "datos_tarjeta")
    private Boolean datos_tarjeta;
    
	@Column(name = "fecha")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;

	public MetodoPago() {
		super();
	}

	public MetodoPago(Long id, String metodo, String descripcion, Boolean activo, Boolean datos_tarjeta, Date fecha) {
		super();
		this.id = id;
		this.metodo = metodo;
		this.descripcion = descripcion;
		this.activo = activo;
		this.datos_tarjeta = datos_tarjeta;
		this.fecha = fecha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Boolean getDatos_tarjeta() {
		return datos_tarjeta;
	}

	public void setDatos_tarjeta(Boolean datos_tarjeta) {
		this.datos_tarjeta = datos_tarjeta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "MetodoPago [id=" + id + ", metodo=" + metodo + ", descripcion=" + descripcion + ", activo=" + activo
				+ ", datos_tarjeta=" + datos_tarjeta + "]";
	}
	
	
}

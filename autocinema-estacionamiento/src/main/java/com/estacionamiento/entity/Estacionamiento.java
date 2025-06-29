package com.estacionamiento.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estacionamiento")
public class Estacionamiento {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id")
    private Long id;
    
    @Column(name = "numero_espacio")
    private Integer numero_espacio;
    @Column(name = "sede_id")
    private Integer sede_id;
    @Column(name = "usuario_id")
    private Integer usuario_id;
    @Column(name = "funcion_id")
    private Integer funcion_id;
    @Column(name = "reservado")
    private Boolean reservado;
	
    public Estacionamiento() {
		super();
	}

	public Estacionamiento(Long id, Integer numero_espacio, Integer sede_id, Integer usuario_id, Integer funcion_id,
			Boolean reservado) {
		super();
		this.id = id;
		this.numero_espacio = numero_espacio;
		this.sede_id = sede_id;
		this.usuario_id = usuario_id;
		this.funcion_id = funcion_id;
		this.reservado = reservado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero_espacio() {
		return numero_espacio;
	}

	public void setNumero_espacio(Integer numero_espacio) {
		this.numero_espacio = numero_espacio;
	}

	public Integer getSede_id() {
		return sede_id;
	}

	public void setSede_id(Integer sede_id) {
		this.sede_id = sede_id;
	}

	public Integer getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Integer usuario_id) {
		this.usuario_id = usuario_id;
	}

	public Integer getFuncion_id() {
		return funcion_id;
	}

	public void setFuncion_id(Integer funcion_id) {
		this.funcion_id = funcion_id;
	}

	public Boolean getReservado() {
		return reservado;
	}

	public void setReservado(Boolean reservado) {
		this.reservado = reservado;
	}

	@Override
	public String toString() {
		return "Estacionamiento [id=" + id + ", numero_espacio=" + numero_espacio + ", sede_id=" + sede_id
				+ ", usuario_id=" + usuario_id + ", funcion_id=" + funcion_id + ", reservado=" + reservado + "]";
	}
    
    
}

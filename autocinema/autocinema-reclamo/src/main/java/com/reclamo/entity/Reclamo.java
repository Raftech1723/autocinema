package com.reclamo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reclamos")
public class Reclamo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id")
    private Long id;
    @Column(name = "usuario_id")
    private String usuario_id;
    @Column(name = "sede_id")
    private String sede_id;
    @Column(name = "confiteria_id")
    private String confiteria_id;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private String estado;
	
    public Reclamo() {
		super();
	}

	public Reclamo(Long id, String usuario_id, String sede_id, String confiteria_id, String descripcion,
			String estado) {
		super();
		this.id = id;
		this.usuario_id = usuario_id;
		this.sede_id = sede_id;
		this.confiteria_id = confiteria_id;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(String usuario_id) {
		this.usuario_id = usuario_id;
	}

	public String getSede_id() {
		return sede_id;
	}

	public void setSede_id(String sede_id) {
		this.sede_id = sede_id;
	}

	public String getConfiteria_id() {
		return confiteria_id;
	}

	public void setConfiteria_id(String confiteria_id) {
		this.confiteria_id = confiteria_id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Reclamo [id=" + id + ", usuario_id=" + usuario_id + ", sede_id=" + sede_id + ", confiteria_id="
				+ confiteria_id + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
    
    
}

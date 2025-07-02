package com.categoria.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "imagen_categoria")
public class ImagenCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ruta_imagen")
    private String rutaImagen;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

	public ImagenCategoria() {
		super();
	}

	public ImagenCategoria(Long id, String rutaImagen, Categoria categoria) {
		super();
		this.id = id;
		this.rutaImagen = rutaImagen;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "ImagenCategoria [id=" + id + ", rutaImagen=" + rutaImagen + ", categoria=" + categoria + "]";
	}



}

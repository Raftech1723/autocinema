package com.pelicula.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pelicula_catalogo")
public class PeliculaCatalogo {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String titulo;
	    private String descripcion;
	    private Integer duracion;

	    @Column(name = "categoria_id")
	    private Long categoriaId;

	    private String imagen;

		public PeliculaCatalogo() {
			super();
		}

		public PeliculaCatalogo(Long id, String titulo, String descripcion, Integer duracion, Long categoriaId,
				String imagen) {
			super();
			this.id = id;
			this.titulo = titulo;
			this.descripcion = descripcion;
			this.duracion = duracion;
			this.categoriaId = categoriaId;
			this.imagen = imagen;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public Integer getDuracion() {
			return duracion;
		}

		public void setDuracion(Integer duracion) {
			this.duracion = duracion;
		}

		public Long getCategoriaId() {
			return categoriaId;
		}

		public void setCategoriaId(Long categoriaId) {
			this.categoriaId = categoriaId;
		}

		public String getImagen() {
			return imagen;
		}

		public void setImagen(String imagen) {
			this.imagen = imagen;
		}

	}
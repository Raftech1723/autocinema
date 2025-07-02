package com.pelicula.DTO;

import com.pelicula.entity.Pelicula;

public class PeliculaDTO {
	private Long id;
    private String titulo;
    private String descripcion;
    private Integer duracion;
    private Long categoriaId;
    private String rutaImagenCategoria;
    private String imagen; 
    public PeliculaDTO() {
        super();
    }

    public PeliculaDTO(Pelicula p, String rutaImagenCategoria) {
    	this.id = p.getId();
        this.titulo = p.getTitulo();
        this.descripcion = p.getDescripcion();
        this.duracion = p.getDuracion();
        this.categoriaId = p.getCategoriaId();
        this.rutaImagenCategoria = rutaImagenCategoria;
        this.imagen = p.getImagen(); 
        
        System.out.println("Película: " + p.getTitulo() + ", Imagen: " + p.getImagen());
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

    public String getRutaImagenCategoria() {
        return rutaImagenCategoria;
    }

    public void setRutaImagenCategoria(String rutaImagenCategoria) {
        this.rutaImagenCategoria = rutaImagenCategoria;
    }
    
    public String getImagen() {
        return imagen;
    }
    
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}

package com.pelicula.dto;

public class PeliculaDTO {
    private Long id;
    private String titulo;

    public PeliculaDTO() {}

    public PeliculaDTO(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
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
}

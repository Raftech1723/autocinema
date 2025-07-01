package com.pelicula.service;

import com.pelicula.cliente.CategoriaCliente;
import com.pelicula.dto.CategoriaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaCliente categoriaCliente;

    public List<CategoriaDTO> listarCategorias() {
        return categoriaCliente.listarCategorias();
    }
}

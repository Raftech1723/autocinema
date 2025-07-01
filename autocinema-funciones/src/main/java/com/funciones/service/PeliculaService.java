package com.funciones.service;

import com.funciones.cliente.PeliculaCliente;
import com.funciones.dto.PeliculaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaCliente peliculaCliente;

    public List<PeliculaDTO> listarPelicula() {
        return peliculaCliente.listarPeliculas();
    }
}

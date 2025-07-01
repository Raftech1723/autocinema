package com.funciones.service;

import com.funciones.cliente.SalaCliente;
import com.funciones.dto.SalaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SalaService {

    @Autowired
    private SalaCliente salaCliente;

    public List<SalaDTO> listarSala() {
        return salaCliente.listarSalas();
    }
}

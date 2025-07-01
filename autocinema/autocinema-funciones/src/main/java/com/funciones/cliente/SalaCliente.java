package com.funciones.cliente;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "autocinema-sala", url = "http://localhost:8005/salas")
public interface SalaCliente {
    @GetMapping
    List<SalaDTO> listarSalas();
}

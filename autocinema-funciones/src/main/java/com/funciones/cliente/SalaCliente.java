package com.funciones.cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "autocinema-sala", path = "/sala")
public interface SalaCliente {
	
	@GetMapping("/{id}")
    SalaDTO obtenerSalaPorId(@PathVariable("id") Long id);

}

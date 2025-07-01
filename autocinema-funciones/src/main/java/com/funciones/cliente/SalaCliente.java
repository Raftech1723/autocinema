package com.funciones.cliente;

import com.funciones.dto.SalaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name = "autocinema-sala", url = "http://localhost:8005") // O el puerto correcto
public interface SalaCliente {

    @GetMapping("/sala") // Asegúrate que este endpoint devuelva todas las salas
    List<SalaDTO> listarSalas();
}

package com.pelicula.cliente;

import com.pelicula.dto.SalaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name = "autocinema-sala", url = "http://localhost:8005")
public interface SalaCliente {

    @GetMapping("/sala")
    List<SalaDTO> listarSalas();
}

package com.boletos.service;

import java.util.List;

import com.boletos.entity.Boletos;

public interface BoletosService {
	
	List<Boletos> listarBoletos(); 
    Boletos getIdBoletos(Long id);
    void crearActualizarBoletos(Boletos boletos); 
    void eliminarBoletos(Long id); 
    Boletos buscarPorId(Long id); 
    void guardar(Boletos boleto);

}

package com.metodopago.service;

import java.util.List;

import com.metodopago.entity.MetodoPago;

public interface MetodoPagoService {
	
	List<MetodoPago> listarMetodoPago();
	MetodoPago getIdMetodoPago(Long id);
	void crearActualizarMetodoPago(MetodoPago metodoPago);
	void eliminarMetodoPago(Long id);

}

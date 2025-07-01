package com.reclamo.service;

import java.util.List;

import com.reclamo.entity.Reclamo;

public interface ReclamoService {
	
	List<Reclamo> listarReclamo();
	Reclamo getIdReclamo(Long id);
	void crearActualizarReclamo(Reclamo reclamo);
	void eliminarReclamo(Long id);

}

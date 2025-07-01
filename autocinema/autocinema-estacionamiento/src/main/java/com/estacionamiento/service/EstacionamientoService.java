package com.estacionamiento.service;

import java.util.List;

import com.estacionamiento.entity.Estacionamiento;

public interface EstacionamientoService {
	
	List<Estacionamiento> listarEstacionamiento();
	Estacionamiento getIdEstacionamiento(Long id);
	void crearActualizarEstacionamiento(Estacionamiento estacionamiento);
	void eliminarEstacionamiento(Long id);
    Estacionamiento buscarPorId(Long id); 
    void guardar(Estacionamiento estacionamiento);

}

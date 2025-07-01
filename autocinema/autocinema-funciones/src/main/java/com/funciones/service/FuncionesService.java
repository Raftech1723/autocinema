package com.funciones.service;

import java.util.List;

import com.funciones.entity.Funciones;

public interface FuncionesService {
	
	List<Funciones> listarFunciones();
	Funciones getIdFunciones(Long id);
	void crearActualizarFunciones(Funciones funciones);
	void eliminarFunciones(Long id);
    Funciones buscarPorId(Long id); 
    void guardar(Funciones funciones);

}

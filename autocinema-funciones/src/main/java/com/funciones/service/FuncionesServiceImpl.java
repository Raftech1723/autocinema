package com.funciones.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funciones.entity.Funciones;
import com.funciones.repository.FuncionesRepository;

@Service
public class FuncionesServiceImpl implements FuncionesService {
	
	@Autowired
	private FuncionesRepository funcionesRepository;

	@Override
	public List<Funciones> listarFunciones() {
		// TODO Auto-generated method stub
		return funcionesRepository.findAll();
	}

	@Override
	public Funciones getIdFunciones(Long id) {
		// TODO Auto-generated method stub
		return funcionesRepository.findById(id).orElse(null);
	}

	@Override
	public void crearActualizarFunciones(Funciones funciones) {
		Funciones fcn = new Funciones();
		fcn.setId(funciones.getId());
		fcn.setFecha(funciones.getFecha());
		fcn.setHora(funciones.getHora());
		fcn.setPelicula_id(funciones.getPelicula_id());
		fcn.setSala_id(funciones.getSala_id());
		funcionesRepository.save(fcn);
	}

	@Override
	public void eliminarFunciones(Long id) {
		funcionesRepository.deleteById(id);
	}
	
	 @Override
	    public Funciones buscarPorId(Long id) {
	        return funcionesRepository.findById(id).orElse(null);
	    }


	@Override
	    public void guardar(Funciones funciones){
	        funcionesRepository.save(funciones);
	    }


}

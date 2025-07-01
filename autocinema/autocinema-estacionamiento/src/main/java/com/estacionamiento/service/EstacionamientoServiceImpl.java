package com.estacionamiento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estacionamiento.entity.Estacionamiento;
import com.estacionamiento.repository.EstacionamientoRepository;

@Service
public class EstacionamientoServiceImpl implements EstacionamientoService {
	
	@Autowired
    private EstacionamientoRepository estacionamientoRepository;

    @Override
    public List<Estacionamiento> listarEstacionamiento() {
        return estacionamientoRepository.findAll();
    }

    @Override
    public Estacionamiento getIdEstacionamiento(Long id) {
        return estacionamientoRepository.findById(id).orElse(null);
    }
    
    @Override
    public Estacionamiento buscarPorId(Long id) {
        return estacionamientoRepository.findById(id).orElse(null);
    }

    @Override
    public void crearActualizarEstacionamiento(Estacionamiento estacionamiento) {
        Estacionamiento e = new Estacionamiento();
        e.setId(estacionamiento.getId());
        e.setNumero_espacio(estacionamiento.getNumero_espacio());
        e.setSede_id(estacionamiento.getSede_id());
        e.setUsuario_id(estacionamiento.getUsuario_id());
        e.setFuncion_id(estacionamiento.getFuncion_id());
        e.setReservado(estacionamiento.getReservado());
        
        estacionamientoRepository.save(e);
    }

    @Override
    public void eliminarEstacionamiento(Long id) {
        estacionamientoRepository.deleteById(id);
    }
    

    @Override
    public void guardar(Estacionamiento estacionamiento) {
        estacionamientoRepository.save(estacionamiento);
    }

}

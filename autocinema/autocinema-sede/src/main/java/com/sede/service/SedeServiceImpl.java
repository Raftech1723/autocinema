package com.sede.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sede.entity.Sede;
import com.sede.repository.SedeRepository;

@Service
public class SedeServiceImpl implements SedeService {
	
	@Autowired
    private SedeRepository sedeRepository;

    @Override
    public List<Sede> listarSede() {
        return sedeRepository.findAll();
    }

    @Override
    public Sede getIdSede(Long id) {
        return sedeRepository.findById(id).orElse(null);
    }

    @Override
    public void crearActualizarSede(Sede sede) {
        Sede s = new Sede();
        s.setId(sede.getId());
        s.setNombre(sede.getNombre());
        s.setDireccion(sede.getDireccion());
        sedeRepository.save(s);
    }

    @Override
    public void eliminarSede(Long id) {
        sedeRepository.deleteById(id);
    }

}

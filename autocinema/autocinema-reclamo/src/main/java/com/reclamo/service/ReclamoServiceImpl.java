package com.reclamo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reclamo.entity.Reclamo;
import com.reclamo.repository.ReclamoRepository;

@Service
public class ReclamoServiceImpl implements ReclamoService {
	
	@Autowired
    private ReclamoRepository reclamoRepository;

    @Override
    public List<Reclamo> listarReclamo() {
        return reclamoRepository.findAll();
    }

    @Override
    public Reclamo getIdReclamo(Long id) {
        return reclamoRepository.findById(id).orElse(null);
    }

    @Override
    public void crearActualizarReclamo(Reclamo reclamo) {
        Reclamo r = new Reclamo();
        r.setId(reclamo.getId());
        r.setUsuario_id(reclamo.getUsuario_id());
        r.setSede_id(reclamo.getSede_id());
        r.setConfiteria_id(reclamo.getConfiteria_id());
        r.setDescripcion(reclamo.getDescripcion());
        r.setEstado(reclamo.getEstado());
        reclamoRepository.save(r);
    }

    @Override
    public void eliminarReclamo(Long id) {
    	reclamoRepository.deleteById(id);
    }

}

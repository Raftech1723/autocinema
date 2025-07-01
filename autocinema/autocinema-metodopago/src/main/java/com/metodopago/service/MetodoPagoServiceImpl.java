package com.metodopago.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metodopago.entity.MetodoPago;
import com.metodopago.repository.MetodoPagoRepository;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService {
	
	@Autowired
    private MetodoPagoRepository metodoPagoRepository;

    @Override
    public List<MetodoPago> listarMetodoPago() {
        return metodoPagoRepository.findAll();
    }

    @Override
    public MetodoPago getIdMetodoPago(Long id) {
        return metodoPagoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarMetodoPago(Long id) {
        metodoPagoRepository.deleteById(id);
    }

	@Override
	public void crearActualizarMetodoPago(MetodoPago metodo) {
		MetodoPago mtd = new MetodoPago();
        mtd.setId(metodo.getId());
        mtd.setMetodo(metodo.getMetodo());
        mtd.setDescripcion(metodo.getDescripcion());
        mtd.setActivo(metodo.getActivo());
        mtd.setDatos_tarjeta(metodo.getDatos_tarjeta());
        mtd.setFecha(metodo.getFecha());
        
        metodoPagoRepository.save(mtd);
		
	}


}

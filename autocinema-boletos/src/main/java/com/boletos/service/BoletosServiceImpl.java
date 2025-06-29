package com.boletos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boletos.entity.Boletos;
import com.boletos.repository.BoletosRepository;

@Service
public class BoletosServiceImpl implements BoletosService {
	
	@Autowired
    private BoletosRepository boletosRepository;

    @Override
    public List<Boletos> listarBoletos() {
        return boletosRepository.findAll();
    }

    @Override
    public Boletos getIdBoletos(Long id) {
        return boletosRepository.findById(id).orElse(null);
    }
    
    @Override
    public Boletos buscarPorId(Long id) {
        return boletosRepository.findById(id).orElse(null);
    }

    @Override
    public void crearActualizarBoletos(Boletos boletos) {
        Boletos b = new Boletos();
        b.setId(boletos.getId());
        b.setUsuario(boletos.getUsuario());
        b.setFuncion(boletos.getFuncion());
        b.setCantidad(boletos.getCantidad());
        b.setTotal(boletos.getTotal());
        b.setMetodoP(boletos.getMetodoP());
        b.setFecha(boletos.getFecha());
        boletosRepository.save(b);
    }

    @Override
    public void eliminarBoletos(Long id) {
        boletosRepository.deleteById(id);
    }
    @Override
    public void guardar(Boletos boleto) {
        boletosRepository.save(boleto);
    }

}

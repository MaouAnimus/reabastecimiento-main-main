package com.ecomarket.reabastecimiento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomarket.reabastecimiento.model.Solreabastecimiento;
import com.ecomarket.reabastecimiento.repository.SolreabastecimientoRepository;

@Service
public class SolreabastecimientoService {
    @Autowired
    private SolreabastecimientoRepository solreabastecimientoRepository;

    public Solreabastecimiento crearSolicitud(Solreabastecimiento resupply) {
        return solreabastecimientoRepository.save(resupply);    
    }

    public Solreabastecimiento findById(Object id_solreabastecimiento) {
        return solreabastecimientoRepository.findById((int) id_solreabastecimiento);    
    }

    public List<Solreabastecimiento> findAll() {
        return solreabastecimientoRepository.findAll();    
    }

    


}

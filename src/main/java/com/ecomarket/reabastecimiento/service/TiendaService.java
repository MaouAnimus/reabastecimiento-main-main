package com.ecomarket.reabastecimiento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomarket.reabastecimiento.model.Tienda;
import com.ecomarket.reabastecimiento.repository.TiendaRepository;

@Service
public class TiendaService {
    @Autowired
    private TiendaRepository tiendaRepository;
    

    public List<Tienda> findAll() {
        return tiendaRepository.findAll();
    }

    public Tienda crear_tienda(Tienda tienda) {
        return tiendaRepository.save(tienda);
    }

    public Tienda findById(int id_tienda) {
        return tiendaRepository.findById(id_tienda);    
    }

    public Tienda updateById(int id, Tienda tienda) {
    Tienda tien = tiendaRepository.findById(id);
        if (tien != null) {
            if (tienda.getNom_tienda() != null) 
                tien.setNom_tienda(tienda.getNom_tienda());
            if (tienda.getDirecc_tienda() != null) 
                tien.setDirecc_tienda(tienda.getDirecc_tienda());
            
            tiendaRepository.save(tien);
            return tien;
        }
        return null;    
    }
    
}

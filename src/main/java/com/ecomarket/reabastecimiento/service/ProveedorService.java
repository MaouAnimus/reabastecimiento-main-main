package com.ecomarket.reabastecimiento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomarket.reabastecimiento.model.Proveedor;
import com.ecomarket.reabastecimiento.repository.ProveedorRepository;

@Service
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    public Proveedor crear_proveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public List<Proveedor> findAll() {
        return proveedorRepository.findAll();    
    }

    public Proveedor updateById(int id_prov, Proveedor proveedor) {
        Proveedor provExist = proveedorRepository.findById(id_prov);
        if (proveedor.getNom_prov() != null) {
            provExist.setNom_prov(proveedor.getNom_prov());
            proveedorRepository.save(provExist);
            return provExist;
        }
        return null;
    }

    public Proveedor findById(int id_prov) {
        return proveedorRepository.findById(id_prov);    
    }
    
}

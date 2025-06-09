package com.ecomarket.reabastecimiento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecomarket.reabastecimiento.model.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

    
    List<Proveedor> findAll();
    
    @SuppressWarnings("unchecked")
    Proveedor save(Proveedor proveedor);
    
    Proveedor findById(int id_prov);
}

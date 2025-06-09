package com.ecomarket.reabastecimiento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomarket.reabastecimiento.model.EncargadoTienda;

@Repository
public interface EncargadoTRepository extends JpaRepository<EncargadoTienda, Integer> {

    

    @SuppressWarnings("unchecked")
    
    EncargadoTienda save(EncargadoTienda encargadoTienda);

    EncargadoTienda findById(int id_encargado);

    List<EncargadoTienda> findAll();

    
}

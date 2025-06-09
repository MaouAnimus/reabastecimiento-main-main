package com.ecomarket.reabastecimiento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomarket.reabastecimiento.model.Tienda;

@Repository
public interface TiendaRepository extends JpaRepository<Tienda, Integer> {
    
    List<Tienda> findAll();
    
    @SuppressWarnings("unchecked")
    Tienda save(Tienda tienda);

    Tienda findById(int id_tienda);
}

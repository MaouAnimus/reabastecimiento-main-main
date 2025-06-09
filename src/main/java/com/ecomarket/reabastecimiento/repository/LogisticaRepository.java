package com.ecomarket.reabastecimiento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomarket.reabastecimiento.model.Logistica;

@Repository
public interface LogisticaRepository extends JpaRepository<Logistica, Integer> {
    
    @SuppressWarnings("unchecked")
    Logistica save(Logistica logistica);
    
    List<Logistica> findAll();

    Logistica findById(int id_logistica);
    
}

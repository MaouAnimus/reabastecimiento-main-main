package com.ecomarket.reabastecimiento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomarket.reabastecimiento.model.Solreabastecimiento;

@Repository
public interface SolreabastecimientoRepository extends JpaRepository<Solreabastecimiento, Integer> {
    
    @SuppressWarnings("unchecked")
    Solreabastecimiento save(Solreabastecimiento solreabastecimiento);
    
    Solreabastecimiento findById(int id_solreabastecimiento);
    
    List<Solreabastecimiento> findAll();

      
}

package com.ecomarket.reabastecimiento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomarket.reabastecimiento.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @SuppressWarnings("unchecked")
    Producto save(Producto producto);

    List<Producto> findAll();
    
    Producto findById(int id_producto);
}

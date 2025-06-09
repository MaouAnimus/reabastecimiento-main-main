package com.ecomarket.reabastecimiento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomarket.reabastecimiento.model.Producto;
import com.ecomarket.reabastecimiento.repository.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Producto findById(int id_producto) {
        return productoRepository.findById(id_producto);
    }

    public Producto crear_producto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto updateById(int id_producto, Producto producto) {
        Producto prodExist = productoRepository.findById(id_producto);
        if (prodExist != null) {
            if (producto.getCodigo_producto() != null) 
                prodExist.setCodigo_producto(producto.getCodigo_producto());
            if (producto.getNombre_producto() != null) 
                prodExist.setNombre_producto(producto.getNombre_producto());
            if (producto.getCantidad_producto() > 0) 
                prodExist.setCantidad_producto(producto.getCantidad_producto());
            productoRepository.save(prodExist);
            return prodExist;
        }
        return null;    
    }
    
}

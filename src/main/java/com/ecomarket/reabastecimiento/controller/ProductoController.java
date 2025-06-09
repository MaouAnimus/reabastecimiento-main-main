package com.ecomarket.reabastecimiento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomarket.reabastecimiento.model.Producto;
import com.ecomarket.reabastecimiento.service.ProductoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping()
    public ResponseEntity<List<Producto>> getAll() {
        List<Producto> productos = productoService.findAll();
        if (!productos.isEmpty()) {
            return new ResponseEntity<>(productos, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    }
    
    @PostMapping("/agregar")
    public ResponseEntity<Producto> postProducto(@RequestBody Producto producto) {
        Producto prod = productoService.findById(producto.getId_producto());
        if (prod == null) {
            return new ResponseEntity<>(productoService.crear_producto(producto), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }    
    }
    
    @PutMapping("actualizar/{id_producto}")
    public ResponseEntity<Producto> putProducto(@PathVariable int id_producto, @RequestBody Producto producto) {
        Producto prod = productoService.updateById(id_producto, producto);
        if (prod != null) {
            return new ResponseEntity<>(prod, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
}

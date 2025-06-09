package com.ecomarket.reabastecimiento.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ecomarket.reabastecimiento.model.Proveedor;
import com.ecomarket.reabastecimiento.service.ProveedorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/proveedor")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping()
    public ResponseEntity<List<Proveedor>> getAll() {
    List<Proveedor> proveedor = proveedorService.findAll();
    if (!proveedor.isEmpty()) {
        return new ResponseEntity<>(proveedor, HttpStatus.OK);    
    } else {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    }

    @PostMapping("/registrar")
    public ResponseEntity<Proveedor> create(@RequestBody Proveedor proveedor) {
        Proveedor prov = proveedorService.crear_proveedor(proveedor);
        return new ResponseEntity<>(prov, HttpStatus.CREATED);
    }
    
    @PutMapping("/actualizar/{id}")
        public ResponseEntity<Proveedor> updateById(@PathVariable int id, @RequestBody Proveedor proveedor) {
        Proveedor prov = proveedorService.updateById(id, proveedor);
        if (prov != null) {
            return new ResponseEntity<>(prov, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id_prov}")
    public ResponseEntity<Proveedor> getById(@PathVariable int id_prov) {
        Proveedor prov = proveedorService.findById(id_prov);
        if (prov != null) {
            return new ResponseEntity<>(prov, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    
}
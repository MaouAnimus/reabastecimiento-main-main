package com.ecomarket.reabastecimiento.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ecomarket.reabastecimiento.model.Tienda;
import com.ecomarket.reabastecimiento.service.TiendaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/tienda")
public class TiendaController {
    @Autowired
    private TiendaService tiendaService;
    
    @GetMapping()
    public ResponseEntity<List<Tienda>> getAll() {
    List<Tienda> tienda = tiendaService.findAll();
    if (!tienda.isEmpty()) {
      return new ResponseEntity<>(tienda, HttpStatus.OK);    
    } else {
     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
    @PostMapping("/registrar")
    public ResponseEntity<Tienda> create(@RequestBody Tienda tienda) {
        Tienda tiend = tiendaService.crear_tienda(tienda);
        return new ResponseEntity<>(tiend, HttpStatus.CREATED);
    }

    @GetMapping("/{id_tienda}")
    public ResponseEntity<Tienda> getById(@RequestParam int id_tienda) {
        Tienda tiend = tiendaService.findById(id_tienda);
        if (tiend != null) {
            return new ResponseEntity<>(tiend, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("actualizar/{id_tienda}")
    public ResponseEntity<Tienda> updateById(@PathVariable int id, @RequestBody Tienda tienda) {
        Tienda tiend = tiendaService.updateById(id, tienda);
        if (tiend != null) {
            return new ResponseEntity<>(tiend, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
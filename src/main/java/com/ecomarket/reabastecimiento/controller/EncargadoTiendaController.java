package com.ecomarket.reabastecimiento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomarket.reabastecimiento.model.EncargadoTienda;
import com.ecomarket.reabastecimiento.service.EncargadoTService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/encargado")
public class EncargadoTiendaController {
    @Autowired
    private EncargadoTService encargadoservice;

    @GetMapping()
    public ResponseEntity<List<EncargadoTienda>> getAll() {
    List<EncargadoTienda> encargados = encargadoservice.findAll();
    if (!encargados.isEmpty()) {
        return new ResponseEntity<>(encargados, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    }

    @PostMapping("/registrar")
    public ResponseEntity<EncargadoTienda> postEncargado(@RequestBody EncargadoTienda encargadoTienda) {   
        EncargadoTienda et = encargadoservice.findById(encargadoTienda.getId_encargado());
        if (et == null) {
            return new ResponseEntity<>(encargadoservice.crear_encargado(encargadoTienda), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EncargadoTienda> updateById(@PathVariable int id, @RequestBody EncargadoTienda encargadoTienda) {
        EncargadoTienda et = encargadoservice.updateById(id, encargadoTienda);
        if (et != null) {
            return new ResponseEntity<>(et, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id_encargado}")
    public ResponseEntity<EncargadoTienda> getById(@PathVariable int id_encargado) {
        EncargadoTienda et = encargadoservice.findById(id_encargado);
        if (et != null) {
            return new ResponseEntity<>(et, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}

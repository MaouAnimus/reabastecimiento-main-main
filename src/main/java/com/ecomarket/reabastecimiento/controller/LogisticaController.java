package com.ecomarket.reabastecimiento.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomarket.reabastecimiento.model.Logistica;
import com.ecomarket.reabastecimiento.service.LogisticaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/logistica")
public class LogisticaController {
    @Autowired
    private LogisticaService logisticaService;

    @GetMapping()
    public ResponseEntity<List<Logistica>> getAll() {
    List<Logistica> logistica = logisticaService.findAll();
    if (!logistica.isEmpty()) 
    {
        return new ResponseEntity<>(logistica, HttpStatus.OK);
    } else 
    {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    }

    @PostMapping("/registrar")
    public ResponseEntity<Logistica> create(@RequestBody Logistica logistica) {
        Logistica log = logisticaService.crear_logistica(logistica);
        return new ResponseEntity<>(log, HttpStatus.CREATED);    
    }

        @PutMapping("/actualizar/{id}")
        public ResponseEntity<Logistica> updateById(@PathVariable int id, @RequestBody Logistica logistica) {
        Logistica log = logisticaService.updateById(id, logistica);
        if (log != null) {
            return new ResponseEntity<>(log, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id_logistica}")
    public ResponseEntity<Logistica> getById(@PathVariable int id_logistica) {
        Logistica log = logisticaService.findById(id_logistica);
        if (log != null) {
            return new ResponseEntity<>(log, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
    
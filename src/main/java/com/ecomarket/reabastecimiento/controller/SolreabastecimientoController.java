package com.ecomarket.reabastecimiento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomarket.reabastecimiento.model.Solreabastecimiento;
import com.ecomarket.reabastecimiento.service.SolreabastecimientoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/resupply")
public class SolreabastecimientoController {
    @Autowired
    private SolreabastecimientoService solreabastecimientoService;

    @GetMapping()
    public ResponseEntity<List<Solreabastecimiento>> getAll() {
    List<Solreabastecimiento> resupply = solreabastecimientoService.findAll();
    if (!resupply.isEmpty()) {
        return new ResponseEntity<>(resupply, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    }

    @PostMapping("/generar")
    public ResponseEntity<Solreabastecimiento> postSolicitud(@RequestBody Solreabastecimiento resupply) {
        Solreabastecimiento solicitud = solreabastecimientoService.findById(resupply.getId_solicitud());
        if (solicitud == null) {
            return new ResponseEntity<>(solreabastecimientoService.crearSolicitud(resupply), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    @GetMapping("/{id_solicitud}")
    public ResponseEntity<Solreabastecimiento> getById(@PathVariable int id_solreabastecimiento) {
        Solreabastecimiento solicitud = solreabastecimientoService.findById(id_solreabastecimiento);
        if (solicitud != null) {
            return new ResponseEntity<>(solicitud, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    
}

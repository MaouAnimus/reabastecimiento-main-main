package com.ecomarket.reabastecimiento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomarket.reabastecimiento.model.EncargadoTienda;
import com.ecomarket.reabastecimiento.repository.EncargadoTRepository;

@Service
public class EncargadoTService {
    @Autowired
    private EncargadoTRepository encargadoRepository;

    public EncargadoTienda findById(int id_encargado) {
        return encargadoRepository.findById(id_encargado);    
    }

    public EncargadoTienda crear_encargado(EncargadoTienda encargadoTienda) {
        return encargadoRepository.save(encargadoTienda);    
    }

    public List<EncargadoTienda> findAll() {
        return encargadoRepository.findAll();    
    }

    public EncargadoTienda updateById(int id, EncargadoTienda encargadoTienda) {
        EncargadoTienda encExist = encargadoRepository.findById(id);
        if (encExist != null) {
            if (encExist.getRut() != null) 
                encExist.setRut(encargadoTienda.getRut());{
            }
            if (encExist.getNombre() != null) 
                encExist.setNombre(encargadoTienda.getNombre());{
            }
            if (encExist.getApellido() != null) 
                encExist.setApellido(encargadoTienda.getApellido());{
            }
            if (encExist.getEmail() != null) 
                encExist.setEmail(encargadoTienda.getEmail());{
            }
            if (encExist.getPassword() != null) 
                encExist.setPassword(encargadoTienda.getPassword());{
            }
            encargadoRepository.save(encExist);
            return encExist;
        }
        return null;
    }
    
}

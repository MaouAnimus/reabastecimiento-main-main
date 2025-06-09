package com.ecomarket.reabastecimiento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecomarket.reabastecimiento.model.Logistica;
import com.ecomarket.reabastecimiento.repository.LogisticaRepository;

@Service
public class LogisticaService {
    @Autowired
    private LogisticaRepository logisticaRepository;

    public Logistica crear_logistica(Logistica logistica) {
        return logisticaRepository.save(logistica);
    }

    public List<Logistica> findAll() {
        return logisticaRepository.findAll();
    }

    public Logistica findById(int id_logistica) {
        return logisticaRepository.findById(id_logistica);
    }

    public Logistica updateById(int id, Logistica logistica) {
        Logistica logExist = logisticaRepository.findById(id);
        if (logExist != null) {
            if (logistica.getRut() != null) {
                logExist.setRut(logistica.getRut());
            }
            if (logistica.getNombre() != null) {
                logExist.setNombre(logistica.getNombre());
            }
            if (logistica.getApellido() != null) {
                logExist.setApellido(logistica.getApellido());
            }
            if (logistica.getEmail() != null) {
                logExist.setEmail(logistica.getEmail());
            }
            if (logistica.getPassword() != null) {
                logExist.setPassword(logistica.getPassword());
            }
            logisticaRepository.save(logExist);
            return logExist;
        }
        return null;
    }
    
    
}

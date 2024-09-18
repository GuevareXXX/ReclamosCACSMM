package com.reclamos.services;

import com.reclamos.model.Agencia;
import com.reclamos.repository.AgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenciaServiceImpl implements AgenciaService{

    @Autowired
    private AgenciaRepository agenciaRepository;

    @Override
    public List<Agencia> listarAgencias() {
        return agenciaRepository.findAll();
    }
}

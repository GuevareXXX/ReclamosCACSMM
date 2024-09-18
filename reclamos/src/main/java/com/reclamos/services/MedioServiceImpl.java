package com.reclamos.services;

import com.reclamos.model.Medio;
import com.reclamos.repository.MedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedioServiceImpl implements MedioService{

    @Autowired
    private MedioRepository medioRepository;

    @Override
    public List<Medio> listarMedio() {
        return medioRepository.findAll();
    }
}

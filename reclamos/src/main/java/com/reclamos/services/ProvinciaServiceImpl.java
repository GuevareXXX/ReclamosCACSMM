package com.reclamos.services;

import com.reclamos.model.Provincia;
import com.reclamos.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinciaServiceImpl implements ProvinciaService{
    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Override
    public List<Provincia> listarProvincias() {
        return provinciaRepository.findAll();
    }
}

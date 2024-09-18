package com.reclamos.services;

import com.reclamos.model.Distrito;
import com.reclamos.repository.DistritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistritoServiceImpl implements DistritoService{
    @Autowired
    private DistritoRepository distritoRepository;

    @Override
    public List<Distrito> listarDistritos() {
        return distritoRepository.findAll();
    }
}

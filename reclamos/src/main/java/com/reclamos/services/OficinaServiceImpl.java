package com.reclamos.services;

import com.reclamos.model.Oficina;
import com.reclamos.repository.OficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OficinaServiceImpl implements OficinaService {

    @Autowired
    private OficinaRepository oficinaRepository;

    @Override
    public List<Oficina> listarOficinas() {
        return oficinaRepository.findAll();
    }
}

package com.reclamos.services;

import com.reclamos.model.Motivo;
import com.reclamos.repository.MotivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotivoServiceImpl implements MotivoService{

    @Autowired
    private MotivoRepository motivoRepository;

    @Override
    public List<Motivo> listarMotivos() {
        return motivoRepository.findAll();
    }
}

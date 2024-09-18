package com.reclamos.services;

import com.reclamos.model.Departamento;
import com.reclamos.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public List<Departamento> listarDepartamentos() {
        return departamentoRepository.findAll();
    }
}

package com.reclamos.services;

import com.reclamos.model.Objeto;
import com.reclamos.repository.ObjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjetoServiceImpl implements ObjetoService{

    @Autowired
    private ObjetoRepository objetoRepository;

    @Override
    public List<Objeto> listarObjetos() {
        return objetoRepository.findAll();
    }
}

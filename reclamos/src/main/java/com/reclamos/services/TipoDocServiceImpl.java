package com.reclamos.services;

import com.reclamos.model.TipoDoc;
import com.reclamos.repository.TipoDocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDocServiceImpl implements TipoDocService{

    @Autowired
    private TipoDocRepository tipoDocRepository;

    @Override
    public List<TipoDoc> listarTipoDoc() {
        return tipoDocRepository.findAll();
    }
}

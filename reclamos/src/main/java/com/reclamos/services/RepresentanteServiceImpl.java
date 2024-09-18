package com.reclamos.services;

import com.reclamos.controller.dto.ReclamoDTO;
import com.reclamos.model.Representante;
import com.reclamos.repository.RepresentanteRepository;
import com.reclamos.repository.TipoDocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepresentanteServiceImpl implements RepresentanteService{

    @Autowired
    private RepresentanteRepository representanteRepository;

    @Autowired
    private TipoDocRepository tipoDocRepository;

    @Override
    public List<Representante> listarRepresentantes() {
        return representanteRepository.findAll();
    }

    @Override
    public Representante guardar(ReclamoDTO reclamoDTO) {
        Representante representante = new Representante(reclamoDTO.getNombresRep(), tipoDocRepository.getById(reclamoDTO.getIdTipoDocRep()),reclamoDTO.getNroDocRep());
        return representanteRepository.save(representante);
    }
}

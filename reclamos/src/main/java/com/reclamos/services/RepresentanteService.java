package com.reclamos.services;

import com.reclamos.controller.dto.ReclamoDTO;
import com.reclamos.model.Representante;

import java.util.List;

public interface RepresentanteService {
    public List<Representante> listarRepresentantes();

    public Representante guardar(ReclamoDTO reclamoDTO);
}

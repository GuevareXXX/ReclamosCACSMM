package com.reclamos.services;

import com.reclamos.controller.dto.ReclamoDTO;
import com.reclamos.controller.dto.ResumenReclamoDTO;
import com.reclamos.model.Reclamo;
import com.reclamos.model.ResumenReclamo;

import java.util.List;

public interface ReclamoService {
    public List<Reclamo> listarReclamos();

    public Reclamo guardar(ReclamoDTO reclamoDTO);

    public ResumenReclamo guardarResumen(ResumenReclamoDTO resumenReclamoDTO);

    public ResumenReclamo guardarObservaciones(ResumenReclamoDTO resumenReclamoDTO, Integer id);

    public Reclamo getReclamo(Integer id);

    public Reclamo actualizarReclamo(Reclamo reclamo);

    public List<Long> calcularDiferenciasDias(List<Reclamo> reclamos);

    public List<String> mostrarAgenciaOficinaAtencion(List<Reclamo> reclamos);
}

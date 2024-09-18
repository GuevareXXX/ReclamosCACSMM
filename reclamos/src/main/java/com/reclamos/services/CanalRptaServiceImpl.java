package com.reclamos.services;

import com.reclamos.model.CanalRpta;
import com.reclamos.repository.CanalRptaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanalRptaServiceImpl implements CanalRptaService{

    @Autowired
    private CanalRptaRepository canalRptaRepository;
    @Override
    public List<CanalRpta> listarCanalesRespuesta() {
        return canalRptaRepository.findAll();
    }
}

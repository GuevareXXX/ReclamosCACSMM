package com.reclamos.services;

import com.reclamos.model.CanalPres;
import com.reclamos.repository.CanalPresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanalPresServiceImpl implements CanalPresService{

    @Autowired
    private CanalPresRepository canalPresRepository;
    @Override
    public List<CanalPres> listarCanalPres() {
        return canalPresRepository.findAll();
    }
}

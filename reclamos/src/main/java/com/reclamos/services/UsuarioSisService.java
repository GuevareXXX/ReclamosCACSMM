package com.reclamos.services;

import com.reclamos.controller.dto.UsuarioRegistroDTO;
import com.reclamos.model.UsuarioSis;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UsuarioSisService extends UserDetailsService {
    public List<UsuarioSis> listarUsuarios();

    public UsuarioSis guardar(UsuarioRegistroDTO registroDTO);

    Optional<UsuarioSis> findById(Integer id);

    public UsuarioSis findByEmail(String email);
}

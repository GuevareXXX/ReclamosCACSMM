package com.reclamos.services;

import com.reclamos.controller.dto.ReclamoDTO;
import com.reclamos.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    public List<Usuario> listarUsuarios();

    public Usuario guardar(ReclamoDTO reclamoDTO);
//
//    public Usuario singup(Usuario usuario);
//
//    Optional<Usuario> findById(Integer id);
//
//    public Usuario findByEmail(String email);
}


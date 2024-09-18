package com.reclamos.repository;

import com.reclamos.model.UsuarioSis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioSisRepository extends JpaRepository<UsuarioSis, Integer> {
    public UsuarioSis findByEmail(String email);

    public Optional<UsuarioSis> findById(Integer id);

    boolean existsByEmail(String e);
}

package com.reclamos.repository;

import com.reclamos.model.Rol;
import com.reclamos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;

import java.util.List;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    @Query("select b from Rol b where b.nombre = :nombre")
    Rol getRol(@Param("nombre") String s);

    @Query("select o from Rol o")
    List<Rol> getRoles(Sort sort);
}

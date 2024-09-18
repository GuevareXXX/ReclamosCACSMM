package com.reclamos.repository;

import com.reclamos.model.Medio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedioRepository extends JpaRepository<Medio, Integer> {

}

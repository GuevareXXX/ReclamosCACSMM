package com.reclamos.repository;

import com.reclamos.model.CanalRpta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanalRptaRepository extends JpaRepository<CanalRpta, Integer> {
}

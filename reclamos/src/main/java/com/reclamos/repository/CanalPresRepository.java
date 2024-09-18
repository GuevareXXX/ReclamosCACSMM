package com.reclamos.repository;

import com.reclamos.model.CanalPres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanalPresRepository extends JpaRepository<CanalPres, Integer> {

}

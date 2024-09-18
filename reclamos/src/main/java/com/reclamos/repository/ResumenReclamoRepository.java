package com.reclamos.repository;

import com.reclamos.model.ResumenReclamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumenReclamoRepository extends JpaRepository<ResumenReclamo, Integer> {

    @Query("select o from ResumenReclamo o where reclamo.id=:id")
    public ResumenReclamo getResumenPorReclamo(@Param("id") Integer idReclamo);

}

package com.reclamos.repository;

import com.reclamos.model.Reclamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReclamoRepository extends JpaRepository<Reclamo, Integer> {

    @Query("select o from Reclamo o where usuarioSis.id=:id and " +
            "(:nombre is null or upper(o.usuario.nombre) like upper(concat('%', :nombre, '%')))")
    public List<Reclamo> listarPorUsuario(@Param("id") Integer idUsuario, @Param("nombre") String nombre);

    @Query("select o from Reclamo o inner join ResumenReclamo p on o.id=p.reclamo.id " +
            "where p.agencia.id=:id1 and p.oficina.id=:id2 and " +
            "(:nombre is null or o.usuario.nombre = :nombre)")
    public List<Reclamo> listarPorCoordinador(@Param("id1") Integer idAgencia, @Param("id2") Integer idOficina, @Param("nombre") String nombre);

    @Query("select o from Reclamo o where " +
            "(:id is null or o.canalPres.id = :id) and " +
            "(:id2 is null or o.medio.id = :id2) and " +
            "(:id3 is null or o.agencia.id = :id3)")
    public List<Reclamo> listarPorParametros(@Param("id") Integer id_canal_pres, @Param("id2") Integer id_medio_reg, @Param("id3") Integer id_agencia);

}

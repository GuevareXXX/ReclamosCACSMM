package com.reclamos.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "gr_oficina")
public class Oficina {
    @Id
    @Column(name = "id_oficina")
    private Integer id;

    @Column(name = "id_agencia")
    private Integer idAgencia;

    @Column(name = "nom_oficina")
    private String nomOficina;
}

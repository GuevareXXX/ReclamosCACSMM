package com.reclamos.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "gr_agencia")
public class Agencia {
    @Id
    @Column(name = "id_agencia")
    private Integer id;

    @Column(name = "nom_agencia")
    private String nomAgencia;
}

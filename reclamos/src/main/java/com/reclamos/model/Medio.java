package com.reclamos.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "gr_medio_reclamo")
public class Medio {
    @Id
    @Column(name = "id_med_reclamo")
    private Integer id;

    @Column(name = "cod_medio_reclamo")
    private String codMedio;

    @Column(name = "nombre")
    private String nombre;
}

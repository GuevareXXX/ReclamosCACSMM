package com.reclamos.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "gr_motivo_reclamo")
public class Motivo {
    @Id
    @Column(name = "id_mot_reclamo")
    private Integer id;

    @Column(name = "cod_motivo_reclamo")
    private String codMotivo;

    @Column(name = "nombre")
    private String nombre;
}

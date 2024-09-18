package com.reclamos.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "gr_obj_reclamo")
public class Objeto {
    @Id
    @Column(name = "id_obj_reclamo")
    private Integer id;

    @Column(name = "cod_obj_reclamo")
    private String codMotivo;

    @Column(name = "nombre")
    private String nombre;
}

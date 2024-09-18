package com.reclamos.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "gr_canal_rpta")
public class CanalRpta {
    @Id
    @Column(name = "id_canal_rtpa")
    private Integer id;

    @Column(name = "cod_rpta")
    private String codRpta;

    @Column(name = "nombre")
    private String nombre;
}

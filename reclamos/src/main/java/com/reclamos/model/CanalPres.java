package com.reclamos.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "gr_canal_pres")
public class CanalPres {
    @Id
    @Column(name = "id_canal_pres")
    private Integer id;

    @Column(name = "cod_canal")
    private String codCanal;

    @Column(name = "nombre")
    private String nombre;
}

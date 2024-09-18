package com.reclamos.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "distritos")
public class Distrito {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "cod_departamento")
    private String codDepartamento;

    @Column(name = "cod_provincia")
    private String codProvincia;

    @Column(name = "cod_distrito")
    private String codDistrito;

    @Column(name = "nom_distrito")
    private String nomDistrito;
}

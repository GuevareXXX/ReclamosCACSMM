package com.reclamos.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.print.attribute.standard.MediaSize;

@Entity
@Data
@Table(name = "provincias")
public class Provincia {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "cod_departamento")
    private String codDepartamento;

    @Column(name = "cod_provincia")
    private String codProvincia;

    @Column(name = "nom_provincia")
    private String nomProvincia;

}

package com.reclamos.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "departamentos")
public class Departamento {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "cod_departamento")
    private String codDepartamento;

    @Column(name = "nom_departamento")
    private String nomDepartamento;
}

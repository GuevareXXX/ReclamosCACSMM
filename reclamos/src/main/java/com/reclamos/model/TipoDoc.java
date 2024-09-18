package com.reclamos.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "tipo_doc")
public class TipoDoc {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "cod_doc")
    private String codDoc;

    @Column(name = "nombre_doc")
    private String nombreDoc;
}

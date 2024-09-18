package com.reclamos.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@Table(name = "gr_representante")
public class Representante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_representante")
    private Integer id;

//    @NotNull
//    @Column(name="id_tipo_doc")
//    private Integer idTipoDoc;

    @NotNull
    @ManyToOne
    @JoinColumn(name="id_tipo_doc", referencedColumnName = "id")
    private TipoDoc tipoDoc;

    @Column(name = "nro_doc")
    private String nroDoc;

    @Column(name = "ape_paterno")
    private String apePaterno;

    @Column(name = "ape_materno")
    private String apeMaterno;

    @Column(name = "nombres")
    private String nombres;


    public  Representante(String nombres, TipoDoc idTipoDoc, String nroDoc){
        this.nombres=nombres;
        this.tipoDoc=idTipoDoc;
        this.nroDoc=nroDoc;

    }
    public Representante(){

    }

}

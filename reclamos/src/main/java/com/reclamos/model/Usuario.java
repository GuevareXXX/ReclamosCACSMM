package com.reclamos.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "gr_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(name = "ind_socio")
    private String indSocio;

//    @NotNull
//    @Column(name = "id_tipo_doc")
//    private Integer idTipoDoc;

    @NotNull
    @ManyToOne
    @JoinColumn(name="id_tipo_doc", referencedColumnName = "id")
    private TipoDoc tipoDoc;

    @Column(name = "nro_doc")
    private String nroDoc;

    @Column(name = "password")
    private String password;

    @Column(name = "ape_paterno")
    private String apePaterno;

    @Column(name = "ape_materno")
    private String apeMaterno;

    @Column(name = "nombres")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "referencia")
    private String referencia;

//    @Column(name = "id_distrito")
//    private Integer idDistrito;
//
//    @Column(name = "id_provincia")
//    private Integer idProvincia;
//
//    @Column(name = "id_departamento")
//    private Integer idDepartamento;

    @ManyToOne
    @JoinColumn(name="id_departamento", referencedColumnName = "id")
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name="id_provincia", referencedColumnName = "id")
    private Provincia provincia;

    @ManyToOne
    @JoinColumn(name="id_distrito", referencedColumnName = "id")
    private Distrito distrito;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "celular")
    private String celular;

    @Column(name = "email",nullable = false)
    private String email;


    public Usuario(String nombre, TipoDoc idTipoDoc,
                   String nroDoc, String direccion,
                   String referencia, Departamento idDepartamento,
                   Provincia idProvincia, Distrito idDistrito,
                   String telefono, String celular,
                   String email) {
        this.nombre=nombre;
        this.tipoDoc=idTipoDoc;
        this.nroDoc=nroDoc;
        this.direccion=direccion;
        this.referencia=referencia;
        this.departamento=idDepartamento;
        this.provincia=idProvincia;
        this.distrito=idDistrito;
        this.telefono=telefono;
        this.celular=celular;
        this.email=email;
    }

    public Usuario() {

    }
}

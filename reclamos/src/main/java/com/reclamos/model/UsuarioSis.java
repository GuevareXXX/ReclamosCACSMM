package com.reclamos.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioSis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(name = "password")
    private String password;

    @Column(name = "ape_paterno")
    private String apePaterno;

    @Column(name = "ape_materno")
    private String apeMaterno;

    @Column(name = "nombres")
    private String nombre;

    @Column(name = "email",nullable = false)
    private String email;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="id_rol", referencedColumnName = "id")
    private Rol rol;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="idagencia", referencedColumnName = "id_agencia")
    private Agencia agencia;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="idoficina", referencedColumnName = "id_oficina")
    private Oficina oficina;

    public UsuarioSis(String nombre, String ape_paterno, String ape_materno,String email, String password, Agencia agencia, Oficina oficina ,Rol roles) {
        this.nombre=nombre;
        this.apePaterno=ape_paterno;
        this.apeMaterno=ape_materno;
        this.email=email;
        this.password=password;
        this.agencia=agencia;
        this.oficina=oficina;
        this.rol=roles;

    }

    public UsuarioSis() {

    }
}

package com.reclamos.model;

import javax.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {

    public final static String ADMIN = "ROL_ADMIN";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rol(Integer id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
    }

    public Rol() {

    }

    public Rol(String nombre) {
        super();
        this.nombre = nombre;
    }
}

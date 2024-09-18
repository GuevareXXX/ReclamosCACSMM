package com.reclamos.controller.dto;

import lombok.Data;
import org.springframework.data.relational.core.sql.In;

@Data
public class UsuarioRegistroDTO {

    private Long id;
    private String nombre;
    private String apepaterno;
    private String apematerno;
    private String email;
    private String password;
    private Integer idAgencia;
    private Integer idOficina;
    private Integer idRol;

    public UsuarioRegistroDTO(String nombre, String apepaterno, String apematerno, String email, String password, Integer idAgencia, Integer idOficina, Integer idRol) {
        super();
        this.nombre = nombre;
        this.apepaterno = apepaterno;
        this.apematerno = apematerno;
        this.email = email;
        this.password = password;
        this.idAgencia = idAgencia;
        this.idOficina = idOficina;
        this.idRol = idRol;
    }

    public UsuarioRegistroDTO() {

    }

}

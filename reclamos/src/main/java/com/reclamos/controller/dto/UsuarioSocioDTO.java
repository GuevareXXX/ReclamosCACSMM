package com.reclamos.controller.dto;

import lombok.Data;

@Data
public class UsuarioSocioDTO {
    private Long id;
    private String indSocio;
    private Integer idTipoDoc;
    private String nroDoc;
    private String password;
    private String apePaterno;
    private String apeMaterno;
    private String nombre;
    private String direccion;
    private String referencia;
    private Integer idDistrito;
    private Integer idProvincia;
    private Integer idDepartamento;
    private String telefono;
    private String celular;
    private String email;

    public UsuarioSocioDTO(String nombre, Integer idTipoDoc, String nroDoc, String direccion, String referencia, Integer idDepartamento,
                   Integer idProvincia, Integer idDistrito, String telefono, String celular, String email) {
        super();
        this.nombre=nombre;
        this.idTipoDoc=idTipoDoc;
        this.nroDoc=nroDoc;
        this.direccion=direccion;
        this.referencia=referencia;
        this.idDepartamento=idDepartamento;
        this.idProvincia=idProvincia;
        this.idDistrito=idDistrito;
        this.telefono=telefono;
        this.celular=celular;
        this.email=email;
    }

    public UsuarioSocioDTO(){

    }
}

package com.reclamos.controller.dto;

import lombok.Data;
@Data
public class RepresentanteDTO {
    private Integer id;
    private Integer idTipoDoc;
    private String nroDoc;
    private String apePaterno;
    private String apeMaterno;
    private String nombres;

    private  RepresentanteDTO(){

    }
}

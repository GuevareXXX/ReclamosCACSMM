package com.reclamos.controller.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class ReclamoDTO {
    //Seccion usuario/soscio
    private String indSocio;
    private Integer idTipoDoc;
    private String nroDoc;
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

    //Seccion Representante
    private Integer idTipoDocRep;
    private String nroDocRep;
    private String apePaternoRep;
    private String apeMaternoRep;
    private String nombresRep;

    //Informacion del reclamo
    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecRegistro;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecVencimiento;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecPresentacion;
    private Integer idCanalPres;
    private Integer idMedioReg;
    private Integer nroHr;
    private String detalleReg;
    private Integer idAgencia;


}

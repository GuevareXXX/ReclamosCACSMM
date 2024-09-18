package com.reclamos.controller.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ResumenReclamoDTO {
    //Detalle de reclamo y tratamiento
    private Integer idReclamo;
    private String resumenReclamo;
    private Integer idObjeto;
    private Integer idMotivo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecNotificacion;
    private Integer idCanalRpta;
    private Integer tiempoAbsolucion;
    private String atendidoAFavor;
    private Integer nroRevision;
    private String observaciones;
    private String medidasCorrectivas;
    private String oportunidadesMejora;
    private String destinoMejora;
    private Integer idAgencia;
    private Integer idOficina;
}

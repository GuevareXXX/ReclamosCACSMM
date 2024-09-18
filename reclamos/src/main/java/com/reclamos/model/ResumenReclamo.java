package com.reclamos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@Table(name = "gr_resu_reclamo")
public class ResumenReclamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resu_reclamo")
    private Integer id;

    //@ManyToOne
    @OneToOne
    @JoinColumn(name="id_reclamo", referencedColumnName = "id_reclamos")
    private Reclamo reclamo;

    @ManyToOne
    @JoinColumn(name="id_objeto_reclamo", referencedColumnName = "id_obj_reclamo")
    private Objeto objeto;

    @ManyToOne
    @JoinColumn(name="id_user_atencion", referencedColumnName = "id_usuario")
    private UsuarioSis usuariosis;

    @ManyToOne
    @JoinColumn(name="id_motivo_reclamo", referencedColumnName = "id_mot_reclamo")
    private Motivo motivo;

    @ManyToOne
    @JoinColumn(name="id_canal_respuesta", referencedColumnName = "id_canal_rtpa")
    private CanalRpta canalRpta;

    @Column(name = "nro_revision")
    private Integer nroRevision;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fec_notificacion")
    private Date fecNotificacion;

    @Column(name = "tiempo_absolucion")
    private Integer tiempoAbsolucion;

    @Column(name = "resumen_reclamo")
    private String resumenReclamo;

    @Column(name = "atenido_a_favor")
    private String atendidoAFavor;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "medidas_correctivas")
    private String medidasCorrectivas;

    @Column(name = "oportunidades_mejora")
    private String oportunidadesMejora;

    @Column(name = "destino_mejora")
    private String destinoMejora;

    //ID_OFICINA_ATENCION
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="id_oficina_atencion", referencedColumnName = "id_oficina")
    private Oficina oficina;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="id_agencia_atencion", referencedColumnName = "id_agencia")
    private Agencia agencia;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fec_rpta")
    private Date fecRpta;

    public ResumenReclamo(){

    }

    public ResumenReclamo( Reclamo reclamo, Objeto objeto, UsuarioSis usuariosis, Motivo motivo, CanalRpta canalRpta, Integer nroRevision,
                          Date fecNotificacion, Integer tiempoAbsolucion, String resumenReclamo, String atendidoAFavor,  String observaciones,String medidasCorrectivas,
                          String oportunidadesMejora, String destinoMejora, Agencia agencia, Oficina oficina){
        this.reclamo=reclamo;
        this.objeto=objeto;
        this.usuariosis=usuariosis;
        this.motivo=motivo;
        this.canalRpta=canalRpta;
        this.nroRevision=nroRevision;
        this.fecNotificacion=fecNotificacion;
        this.tiempoAbsolucion=tiempoAbsolucion;
        this.resumenReclamo=resumenReclamo;
        this.atendidoAFavor=atendidoAFavor;
        this.observaciones=observaciones;
        this.medidasCorrectivas=medidasCorrectivas;
        this.oportunidadesMejora=oportunidadesMejora;
        this.destinoMejora=destinoMejora;
        this.agencia=agencia;
        this.oficina=oficina;
    }

}

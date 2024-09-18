package com.reclamos.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data //lombok
@Entity
@Table(name = "gr_reclamos")
public class Reclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reclamos")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

//    @Column(name = "id_usuario")
//    private Integer idUsuario;

//    @Column(name = "id_representante")
//    private Integer idRepresentante;

    @ManyToOne
    @JoinColumn(name="id_representante", referencedColumnName = "id_representante")
    private Representante representante;

//    @NotNull
//    @Column(name = "id_canal_pres")
//    private Integer idCanalPres;

    @NotNull
    @ManyToOne
    @JoinColumn(name="id_canal_pres", referencedColumnName = "id_canal_pres")
    private CanalPres canalPres;

//    @NotNull
//    @Column(name = "id_medio_reg")
//    private Integer idMedioReg;

    @NotNull
    @ManyToOne
    @JoinColumn(name="id_medio_reg", referencedColumnName = "id_med_reclamo")
    private Medio medio;

//    @Column(name = "id_usr_reg")
//    private Integer idUsrReg;

    @ManyToOne
    @JoinColumn(name="id_usr_reg", referencedColumnName = "id_usuario")
    private UsuarioSis usuarioSis;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fec_registro")
    private Date fecRegistro;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fec_vencimiento")
    private Date fecVencimiento;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fec_presentacion")
    private Date fecPresentacion;

    @Column(name = "nro_hr")
    private Integer nroHr;

    @Column(name = "detalle_reg")
    private String detalleReg;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private ReclamoStatus estado;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="id_agencia_reg", referencedColumnName = "id_agencia")
    private Agencia agencia;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fec_rpta")
    private Date fecRpta;

    public enum ReclamoStatus {
        PEN,
        ACT,
        PROS
    }

    public Reclamo(Date fecPresentacion,Date fecVencimiento,
                   Date fecRegistro, CanalPres canalPres,
                   Medio idMedioReg, Integer nroHr,String detalleReg,
                   UsuarioSis idUsrReg,Usuario usuario,Representante idRepresentante, ReclamoStatus estado, Agencia agencia){
        this.fecPresentacion=fecPresentacion;
        this.fecVencimiento=fecVencimiento;
        this.fecRegistro=fecRegistro;
        this.canalPres=canalPres;
        this.medio=idMedioReg;
        this.nroHr=nroHr;
        this.detalleReg=detalleReg;
        this.usuarioSis=idUsrReg;
        this.usuario=usuario;
        this.representante=idRepresentante;
        this.estado=estado;
        this.agencia=agencia;
    }
    public Reclamo(){

    }

}

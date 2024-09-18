package com.reclamos.services;

import com.reclamos.controller.dto.ReclamoDTO;
import com.reclamos.controller.dto.ResumenReclamoDTO;
import com.reclamos.model.*;
import com.reclamos.repository.*;
import com.reclamos.security.AppUserDetails;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.PrivilegedAction;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ReclamoServiceImpl implements ReclamoService{

    @Autowired
    private ReclamoRepository reclamoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioSisRepository usuarioSisRepository;

    @Autowired
    private RepresentanteRepository representanteRepository;

    @Autowired
    private CanalPresRepository canalPresRepository;

    @Autowired
    private MedioRepository medioRepository;

    @Autowired
    private  TipoDocRepository tipoDocRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Autowired
    private DistritoRepository distritoRepository;

    @Autowired
    private ObjetoRepository objetoRepository;

    @Autowired
    private ResumenReclamoRepository resumenReclamoRepository;

    @Autowired
    private MotivoRepository motivoRepository;

    @Autowired
    private CanalRptaRepository canalRptaRepository;

    @Autowired
    private AgenciaRepository agenciaRepository;

    @Autowired
    private OficinaRepository oficinaRepository;

    @Override
    public List<Reclamo> listarReclamos() {
        return reclamoRepository.findAll();
    }

    @Override
    public Reclamo guardar(ReclamoDTO reclamoDTO) {
        //Obtener usuario en sesion
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUserDetails appUserDetails = null;
        if (principal instanceof AppUserDetails) {
            appUserDetails = (AppUserDetails) principal;
        }
        String email = appUserDetails.getEmail();
        UsuarioSis usuarioSis = usuarioSisRepository.findByEmail(email);

        //Para el usuario reclamoDTO.getIdTipoDoc()
        Usuario usuario = new Usuario(reclamoDTO.getNombre(),tipoDocRepository.getById(reclamoDTO.getIdTipoDoc()),reclamoDTO.getNroDoc(),reclamoDTO.getDireccion(),
                reclamoDTO.getReferencia(),departamentoRepository.getById(reclamoDTO.getIdDepartamento()),provinciaRepository.getById(reclamoDTO.getIdProvincia()),distritoRepository.getById(reclamoDTO.getIdDistrito()),
                reclamoDTO.getTelefono(),reclamoDTO.getCelular(),reclamoDTO.getEmail());
        usuarioRepository.save(usuario);

        //Para el representante
        if (reclamoDTO.getNombresRep().isEmpty() && reclamoDTO.getNroDocRep().isEmpty()) {
            Reclamo reclamo = new Reclamo(reclamoDTO.getFecPresentacion(),reclamoDTO.getFecVencimiento(), new Date(),
                    canalPresRepository.getById(reclamoDTO.getIdCanalPres()),medioRepository.getById(reclamoDTO.getIdMedioReg()),reclamoDTO.getNroHr(),reclamoDTO.getDetalleReg(),
                    usuarioSisRepository.getById(usuarioSis.getId()),usuarioRepository.getById(usuario.getId()),null, Reclamo.ReclamoStatus.PEN, agenciaRepository.getById(reclamoDTO.getIdAgencia())
            );
            return reclamoRepository.save(reclamo);
        }
        else {
            Representante representante = new Representante(reclamoDTO.getNombresRep(), tipoDocRepository.getById(reclamoDTO.getIdTipoDocRep()), reclamoDTO.getNroDocRep());
            representanteRepository.save(representante);

            Reclamo reclamo = new Reclamo(reclamoDTO.getFecPresentacion(),reclamoDTO.getFecVencimiento(), new Date(),
                    canalPresRepository.getById(reclamoDTO.getIdCanalPres()),medioRepository.getById(reclamoDTO.getIdMedioReg()),reclamoDTO.getNroHr(),reclamoDTO.getDetalleReg(),
                    usuarioSisRepository.getById(usuarioSis.getId()),usuarioRepository.getById(usuario.getId()),representanteRepository.getById(representante.getId()),Reclamo.ReclamoStatus.PEN,agenciaRepository.getById(reclamoDTO.getIdAgencia())
            );
            return reclamoRepository.save(reclamo);
        }

        //return reclamoRepository.save(reclamo);
    }

    @Override
    public ResumenReclamo guardarResumen(ResumenReclamoDTO resumenReclamoDTO) {
        //Obtener usuario en sesion
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUserDetails appUserDetails = null;
        if (principal instanceof AppUserDetails) {
            appUserDetails = (AppUserDetails) principal;
        }
        String email = appUserDetails.getEmail();
        UsuarioSis usuarioSis = usuarioSisRepository.findByEmail(email);

        ResumenReclamo resumenReclamo = new ResumenReclamo(reclamoRepository.getById(resumenReclamoDTO.getIdReclamo()), objetoRepository.getById(resumenReclamoDTO.getIdObjeto()),usuarioSisRepository.getById(usuarioSis.getId()),
                motivoRepository.getById(resumenReclamoDTO.getIdMotivo()), canalRptaRepository.getById(resumenReclamoDTO.getIdCanalRpta()),resumenReclamoDTO.getNroRevision(),resumenReclamoDTO.getFecNotificacion(), resumenReclamoDTO.getTiempoAbsolucion(),
                resumenReclamoDTO.getResumenReclamo(),resumenReclamoDTO.getAtendidoAFavor(),resumenReclamoDTO.getObservaciones(), resumenReclamoDTO.getMedidasCorrectivas(), resumenReclamoDTO.getOportunidadesMejora(),
                resumenReclamoDTO.getDestinoMejora(), agenciaRepository.getById(resumenReclamoDTO.getIdAgencia()),oficinaRepository.getById(resumenReclamoDTO.getIdOficina())
        );
        return resumenReclamoRepository.save(resumenReclamo);
    }

    @Override
    public ResumenReclamo guardarObservaciones(ResumenReclamoDTO resumenReclamoDTO, Integer id) {
        ResumenReclamo resumenReclamo = resumenReclamoRepository.getResumenPorReclamo(id);
        Reclamo reclamo = reclamoRepository.getById(id);
        resumenReclamo.setAtendidoAFavor(resumenReclamoDTO.getAtendidoAFavor());
        resumenReclamo.setObservaciones(resumenReclamoDTO.getObservaciones());
        resumenReclamo.setMedidasCorrectivas(resumenReclamoDTO.getMedidasCorrectivas());
        resumenReclamo.setOportunidadesMejora(resumenReclamoDTO.getOportunidadesMejora());
        resumenReclamo.setDestinoMejora(resumenReclamoDTO.getDestinoMejora());
        resumenReclamo.setFecRpta(new Date());
        reclamo.setFecRpta(new Date());
        reclamo.setEstado(Reclamo.ReclamoStatus.ACT);
        reclamoRepository.save(reclamo);
        resumenReclamoRepository.save(resumenReclamo);
        return null;
    }

    @Override
    public Reclamo getReclamo(Integer id) {
        return reclamoRepository.getById(id);
    }

    @Override
    public Reclamo actualizarReclamo(Reclamo reclamo) {
        return reclamoRepository.save(reclamo);
    }

    @Override
    public List<Long> calcularDiferenciasDias(List<Reclamo> reclamos) {
        List<Long> diferenciasDias = new ArrayList<>();
        for (Reclamo reclamo : reclamos) {
            Date fecPresentacion = reclamo.getFecPresentacion();
            Date fecRpta = reclamo.getFecRpta();

            if (fecRpta == null) {
                fecRpta = new Date();  // Si es nulo, asignar la fecha actual
            }
            long diferenciaEnMilisegundos = fecRpta.getTime() - fecPresentacion.getTime();
            long diferenciaDias = TimeUnit.DAYS.convert(diferenciaEnMilisegundos, TimeUnit.MILLISECONDS);
            diferenciasDias.add(diferenciaDias);
        }
        return diferenciasDias;
    }

    @Override
    public List<String> mostrarAgenciaOficinaAtencion(List<Reclamo> reclamos) {
        List<String> agenciaOficina = new ArrayList<>();
        for (Reclamo reclamo : reclamos){
            ResumenReclamo resumenReclamo = resumenReclamoRepository.getResumenPorReclamo(reclamo.getId());
            if (resumenReclamo == null){
                agenciaOficina.add(null);
            }
            else {
                String agencia = resumenReclamo.getAgencia().getNomAgencia();
                String oficina = resumenReclamo.getOficina().getNomOficina();
                agenciaOficina.add(agencia + " - " + oficina);
            }
        }
        return agenciaOficina;
    }
}

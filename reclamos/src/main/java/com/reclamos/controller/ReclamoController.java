package com.reclamos.controller;

import com.reclamos.controller.dto.ReclamoDTO;
import com.reclamos.controller.dto.ResumenReclamoDTO;
import com.reclamos.controller.dto.UsuarioRegistroDTO;
import com.reclamos.controller.dto.UsuarioSocioDTO;
import com.reclamos.exception.BadRequestException;
import com.reclamos.model.Reclamo;
import com.reclamos.model.Representante;
import com.reclamos.model.ResumenReclamo;
import com.reclamos.model.Usuario;
import com.reclamos.repository.AgenciaRepository;
import com.reclamos.repository.ReclamoRepository;
import com.reclamos.repository.RepresentanteRepository;
import com.reclamos.repository.ResumenReclamoRepository;
import com.reclamos.services.*;
import javassist.tools.web.BadHttpRequest;
import org.hibernate.dialect.identity.DB2390IdentityColumnSupport;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import javax.management.BadAttributeValueExpException;
import java.security.PrivilegedAction;
import java.time.LocalDate;
import java.util.List;

@Controller
public class ReclamoController {
    @Autowired
    private ReclamoService reclamoService;

    @Autowired
    private CanalPresService canalPresService;

    @Autowired
    private MedioService medioService;

    @Autowired
    private CanalRptaService canalRptaService;

    @Autowired
    private MotivoService motivoService;

    @Autowired
    private ObjetoService objetoService;

    @Autowired
    private RepresentanteService representanteService;

    @Autowired
    private AgenciaService agenciaService;

    @Autowired
    private OficinaService oficinaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TipoDocService tipoDocService;

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private ProvinciaService provinciaService;

    @Autowired
    private DistritoService distritoService;

    @Autowired
    private ResumenReclamoRepository resumenReclamoRepository;

    @Autowired
    private ReclamoRepository reclamoRepository;

//    @ModelAttribute("reclamo")
//    public UsuarioSocioDTO retornarNuevoUsuarioSocioDTO() {
//        return new UsuarioSocioDTO();
//    }

    @ModelAttribute("reclamo")
    public ReclamoDTO retornarNuevoReclamoDTO() {
        return new ReclamoDTO();
    }

    @ModelAttribute("resumenreclamo")
    public ResumenReclamoDTO retornarResumenReclamoDTO() {
        return new ResumenReclamoDTO();
    }

    @GetMapping("/reclamo")
    public String listarReclamos(Model modelo){
        modelo.addAttribute("canalespres", canalPresService.listarCanalPres());
        modelo.addAttribute("medios", medioService.listarMedio());
        modelo.addAttribute("canalesrpta", canalRptaService.listarCanalesRespuesta());
        modelo.addAttribute("motivos", motivoService.listarMotivos());
        modelo.addAttribute("objetos", objetoService.listarObjetos());
        modelo.addAttribute("representantes", representanteService.listarRepresentantes());
        modelo.addAttribute("agencias", agenciaService.listarAgencias());
        modelo.addAttribute("usuarios", usuarioService.listarUsuarios());
        modelo.addAttribute("tipodocs", tipoDocService.listarTipoDoc());
        modelo.addAttribute("departamentos", departamentoService.listarDepartamentos());
        modelo.addAttribute("provincias", provinciaService.listarProvincias());
        modelo.addAttribute("distritos", distritoService.listarDistritos());
        return "reclamo";
    }

    @PostMapping("/reclamo")
    public String registrarReclamo(@ModelAttribute("reclamo") ReclamoDTO reclamoDTO) {
        //usuarioService.guardar(reclamoDTO);
        //representanteService.guardar(reclamoDTO);
        reclamoService.guardar(reclamoDTO);
        return "redirect:/reclamo?exito";
    }

    @GetMapping("/reclamo-view-{id}")
    public String viewReclamo(Model model, @PathVariable Integer id){
        model.addAttribute("reclamo", reclamoService.getReclamo(id));
        model.addAttribute("resumen", resumenReclamoRepository.getResumenPorReclamo(id));
        return "reclamoview";
    }

    @GetMapping("/reclamo-edit-{id}")
    public String editReclamo(Model model, @PathVariable Integer id){
        model.addAttribute("motivos", motivoService.listarMotivos());
        model.addAttribute("objetos", objetoService.listarObjetos());
        model.addAttribute("canalesrpta", canalRptaService.listarCanalesRespuesta());
        model.addAttribute("reclamo", reclamoService.getReclamo(id));
        model.addAttribute("resumen", resumenReclamoRepository.getResumenPorReclamo(id));
        model.addAttribute("agencias", agenciaService.listarAgencias());
        model.addAttribute("oficinas", oficinaService.listarOficinas());
        System.out.println("Resumennn extraido es: " + resumenReclamoRepository.getResumenPorReclamo(id));
        return "reclamoedit";
    }

    @PostMapping("/reclamo-edit-{id}")
    public String guardarResumenReclamo(Model model, @PathVariable Integer id, @ModelAttribute("resumenreclamo") ResumenReclamoDTO resumenReclamoDTO){
        Reclamo reclamo = reclamoService.getReclamo(id);
        if(reclamo.getEstado().name().equals("PROS")){
            System.out.println("Validando si ya se registró el resumen...");
            throw new BadRequestException("Ya existe resumen registrado para el Reclamo seleccionado.");
        }
        else {
            resumenReclamoDTO.setIdReclamo(id);
            reclamoService.guardarResumen(resumenReclamoDTO);
            reclamo.setEstado(Reclamo.ReclamoStatus.PROS);
            reclamoService.actualizarReclamo(reclamo);
        }

        return "redirect:/?exitoresumen";
    }

    @GetMapping("/reclamo-edit-obs-{id}")
    public String editObsReclamo(Model model, @PathVariable Integer id){
        model.addAttribute("motivos", motivoService.listarMotivos());
        model.addAttribute("objetos", objetoService.listarObjetos());
        model.addAttribute("canalesrpta", canalRptaService.listarCanalesRespuesta());
        model.addAttribute("reclamo", reclamoService.getReclamo(id));
        model.addAttribute("resumen", resumenReclamoRepository.getResumenPorReclamo(id));
        return "reclamoeditobs";
    }

    @PostMapping("/reclamo-edit-obs-{id}")
    public String guardarObsReclamo(Model model, @PathVariable Integer id, @ModelAttribute("resumenreclamo") ResumenReclamoDTO resumenReclamoDTO){
        reclamoService.guardarObservaciones(resumenReclamoDTO, id);
        return "redirect:/?exitoobs";
    }


}

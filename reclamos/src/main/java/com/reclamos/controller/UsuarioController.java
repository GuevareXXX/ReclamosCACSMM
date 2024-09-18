package com.reclamos.controller;

import com.reclamos.model.Reclamo;
import com.reclamos.model.Rol;
import com.reclamos.model.Usuario;
import com.reclamos.model.UsuarioSis;
import com.reclamos.repository.*;
import com.reclamos.security.AppUserDetails;
import com.reclamos.services.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class UsuarioController {

    private final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

//    @GetMapping({"/login","/"}) //Java 17
//    public ModelAndView login() {
//        return new ModelAndView("/login");
//    }

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioSisRepository usuarioSisRepository;

    @Autowired
    private ReclamoRepository reclamoRepository;

    @Autowired
    private CanalPresService canalPresService;

    @Autowired
    private AgenciaService agenciaService;

    @Autowired
    private MedioService medioService;

    @Autowired
    private ReclamoService reclamoService;

    @GetMapping("/login") //Java 8
    public String iniciarSesion() {
        return "login";
    }

    @GetMapping("/")
    public String verPaginaDeInicio(Model model, @RequestParam(value = "cp", required = false) Integer idCanalPres,
                                                 @RequestParam(value = "mr", required = false) Integer idMedioReg,
                                                 @RequestParam(value = "ag", required = false) Integer idAgencia,
                                                 @RequestParam(value = "nombre", required = false) String nombre) {
        //Para el usuario en sesion
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUserDetails appUserDetails = null;
        if (principal instanceof AppUserDetails) {
            appUserDetails = (AppUserDetails) principal;
        }
        String email = appUserDetails.getEmail();
        UsuarioSis usuarioSis = usuarioSisRepository.findByEmail(email);
        model.addAttribute("usuariosis",usuarioSis);

        if (usuarioSis.getRol().getNombre().equals("ROL_ADMIN")){
            List<Reclamo> reclamos = reclamoRepository.listarPorParametros(idCanalPres, idMedioReg, idAgencia);
            model.addAttribute("reclamos", reclamos);
            //Calcular la diferencia de días para cada reclamo y almacenarla en el modelo
            List<Long> diferenciasDias = reclamoService.calcularDiferenciasDias(reclamos);
            model.addAttribute("diferenciasDias", diferenciasDias);
            //Mostrar agencia y oficina de atencion
            List<String> agenciaOficina = reclamoService.mostrarAgenciaOficinaAtencion(reclamos);
            model.addAttribute("agenciaOficina", agenciaOficina);

            System.out.println("Lista modo admin: " + reclamos);
        }
        else if (usuarioSis.getRol().getNombre().equals("ROL_COORDINADOR")) {
            if (nombre != null && !nombre.isEmpty()) {
                List<Reclamo> reclamos = reclamoRepository.listarPorCoordinador(usuarioSis.getAgencia().getId(),usuarioSis.getOficina().getId(), nombre);
                model.addAttribute("reclamos", reclamos);
                //Calcular la diferencia de días para cada reclamo y almacenarla en el modelo
                List<Long> diferenciasDias = reclamoService.calcularDiferenciasDias(reclamos);
                model.addAttribute("diferenciasDias", diferenciasDias);
                //Mostrar agencia y oficina de atencion
                List<String> agenciaOficina = reclamoService.mostrarAgenciaOficinaAtencion(reclamos);
                model.addAttribute("agenciaOficina", agenciaOficina);
                System.out.println("Lista modo user: " + reclamos);
            } else {
                List<Reclamo> reclamos = reclamoRepository.listarPorCoordinador(usuarioSis.getAgencia().getId(),usuarioSis.getOficina().getId(), null);
                model.addAttribute("reclamos", reclamos);
                //Calcular la diferencia de días para cada reclamo y almacenarla en el modelo
                List<Long> diferenciasDias = reclamoService.calcularDiferenciasDias(reclamos);
                model.addAttribute("diferenciasDias", diferenciasDias);
                //Mostrar agencia y oficina de atencion
                List<String> agenciaOficina = reclamoService.mostrarAgenciaOficinaAtencion(reclamos);
                model.addAttribute("agenciaOficina", agenciaOficina);
                System.out.println("Lista modo user: " + reclamos);
            }
        }
        else {
            if (nombre != null && !nombre.isEmpty()) {
                List<Reclamo> reclamos = reclamoRepository.listarPorUsuario(usuarioSis.getId(), nombre);
                model.addAttribute("reclamos", reclamos);
                //Calcular la diferencia de días para cada reclamo y almacenarla en el modelo
                List<Long> diferenciasDias = reclamoService.calcularDiferenciasDias(reclamos);
                model.addAttribute("diferenciasDias", diferenciasDias);
                //Mostrar agencia y oficina de atencion
                List<String> agenciaOficina = reclamoService.mostrarAgenciaOficinaAtencion(reclamos);
                model.addAttribute("agenciaOficina", agenciaOficina);
                System.out.println("Lista modo user: " + reclamos);
            } else {
                List<Reclamo> reclamos = reclamoRepository.listarPorUsuario(usuarioSis.getId(), null);
                model.addAttribute("reclamos", reclamos);
                //Calcular la diferencia de días para cada reclamo y almacenarla en el modelo
                List<Long> diferenciasDias = reclamoService.calcularDiferenciasDias(reclamos);
                model.addAttribute("diferenciasDias", diferenciasDias);
                //Mostrar agencia y oficina de atencion
                List<String> agenciaOficina = reclamoService.mostrarAgenciaOficinaAtencion(reclamos);
                model.addAttribute("agenciaOficina", agenciaOficina);
                System.out.println("Lista modo user: " + reclamos);
            }
        }


        model.addAttribute("canalespres", canalPresService.listarCanalPres());
        model.addAttribute("agencias", agenciaService.listarAgencias());
        model.addAttribute("medios", medioService.listarMedio());
        return "index";
    }

}

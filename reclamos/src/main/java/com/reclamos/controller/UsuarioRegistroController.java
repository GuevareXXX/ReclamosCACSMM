package com.reclamos.controller;

import com.reclamos.controller.dto.UsuarioRegistroDTO;
import com.reclamos.services.AgenciaService;
import com.reclamos.services.OficinaService;
import com.reclamos.services.RolService;
import com.reclamos.services.UsuarioSisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class UsuarioRegistroController {
    private UsuarioSisService usuarioSisService;

    @Autowired
    private AgenciaService agenciaService;

    @Autowired
    private OficinaService oficinaService;

    @Autowired
    private RolService rolService;

    public UsuarioRegistroController(UsuarioSisService usuarioSisService) {
        super();
        this.usuarioSisService = usuarioSisService;
    }

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }

    @GetMapping
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("agencias", agenciaService.listarAgencias());
        model.addAttribute("oficinas", oficinaService.listarOficinas());
        model.addAttribute("roles", rolService.listarRoles());
        return "registro";
    }

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
        System.out.println("Iniciando registro de:" + registroDTO.getEmail());
        usuarioSisService.guardar(registroDTO);
        return "redirect:/registro?exito";
    }
}

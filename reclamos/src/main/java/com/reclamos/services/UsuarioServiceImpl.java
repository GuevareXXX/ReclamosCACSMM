package com.reclamos.services;

import com.reclamos.controller.dto.ReclamoDTO;
import com.reclamos.controller.dto.UsuarioSocioDTO;
import com.reclamos.model.Rol;
import com.reclamos.model.Usuario;
import com.reclamos.repository.*;
import com.reclamos.security.AppUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.PortResolverImpl;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.management.BadAttributeValueExpException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoDocRepository tipoDocRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Autowired
    private DistritoRepository distritoRepository;

//
//    @Autowired
//    private RolRepository rolRepository;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario guardar(ReclamoDTO reclamoDTO) {
        Usuario usuario = new Usuario(reclamoDTO.getNombre(),tipoDocRepository.getById(reclamoDTO.getIdTipoDoc()),reclamoDTO.getNroDoc(),reclamoDTO.getDireccion(),
                reclamoDTO.getReferencia(),departamentoRepository.getById(reclamoDTO.getIdDepartamento()),provinciaRepository.getById(reclamoDTO.getIdProvincia()),distritoRepository.getById(reclamoDTO.getIdDistrito()),
                reclamoDTO.getTelefono(),reclamoDTO.getCelular(),reclamoDTO.getEmail());
        return usuarioRepository.save(usuario);
    }

//
//    @Override
//    public Usuario singup(@RequestBody @Validated Usuario usuario) {
//        boolean emailAlreadyExists = usuarioRepository.existsByEmail(usuario.getEmail());
//
//        if (emailAlreadyExists) {
//            return null;
//        }
//        usuario.setNombre(usuario.getNombre());
//        usuario.setApePaterno(usuario.getApePaterno());
//        usuario.setApeMaterno(usuario.getApeMaterno());
//        usuario.setEmail((usuario.getEmail()));
//        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
//        usuario.setRol(rolRepository.getRol("ROL_USER"));
//
//        return usuarioRepository.save(usuario);
//    }
//
//    @Override
//    public Optional<Usuario> findById(Integer id) {
//        return usuarioRepository.findById(id);
//    }
//
//    @Override
//    public Usuario findByEmail(String email) {
//        return usuarioRepository.findByEmail(email);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Usuario usuario = usuarioRepository.findByEmail(username);
//        if(usuario == null) {
//            throw new UsernameNotFoundException("Usuario o password inválidos");
//        }
//        System.out.println(usuario);
//
////        return org.springframework.security.core.userdetails.User
////                .withUsername(usuario.getEmail())
////                .password(usuario.getPassword())
////                .roles(usuario.getRol().getNombre())
////                .build();
//
//        return new AppUserDetails(usuario.getNombre(),
//                usuario.getApePaterno(),
//                usuario.getApeMaterno(),
//                usuario.getEmail(),
//                usuario.getPassword(),
//                usuario.getRol());
//
//        //return new User(usuario.getEmail(),usuario.getPassword(), usuario.getRol());
//    }
//
//    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
//        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
//    }




}

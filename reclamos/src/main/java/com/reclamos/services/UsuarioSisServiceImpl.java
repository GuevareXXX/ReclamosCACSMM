package com.reclamos.services;

import com.reclamos.controller.dto.UsuarioRegistroDTO;
import com.reclamos.model.Agencia;
import com.reclamos.model.Rol;
import com.reclamos.model.UsuarioSis;
import com.reclamos.repository.AgenciaRepository;
import com.reclamos.repository.OficinaRepository;
import com.reclamos.repository.RolRepository;
import com.reclamos.repository.UsuarioSisRepository;
import com.reclamos.security.AppUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioSisServiceImpl implements UsuarioSisService{
    @Autowired
    private UsuarioSisRepository usuarioSisRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private AgenciaRepository agenciaRepository;

    @Autowired
    private OficinaRepository oficinaRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<UsuarioSis> listarUsuarios() {
        return usuarioSisRepository.findAll();
    }

    @Override
    public UsuarioSis guardar(UsuarioRegistroDTO registroDTO) {
        UsuarioSis usuario = new UsuarioSis(registroDTO.getNombre(),
                registroDTO.getApepaterno(),registroDTO.getApematerno(),registroDTO.getEmail(),
                passwordEncoder.encode(registroDTO.getPassword()),  agenciaRepository.getById(registroDTO.getIdAgencia()),
                oficinaRepository.getById(registroDTO.getIdOficina()), rolRepository.getById(registroDTO.getIdRol()));
        return usuarioSisRepository.save(usuario);
    }

    @Override
    public Optional<UsuarioSis> findById(Integer id) {
        return usuarioSisRepository.findById(id);
    }

    @Override
    public UsuarioSis findByEmail(String email) {
        return usuarioSisRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        UsuarioSis usuario = usuarioSisRepository.findByEmail(username);
        if(usuario == null) {
            throw new UsernameNotFoundException("Usuario o password inválidos");
        }
        System.out.println(usuario);

        grantedAuthorityList.add(new SimpleGrantedAuthority(usuario.getRol().getNombre()));

        return new AppUserDetails(usuario.getNombre(),
                usuario.getApePaterno(),
                usuario.getApeMaterno(),
                usuario.getEmail(),
                usuario.getPassword(),
                usuario.getRol(),
                grantedAuthorityList);

        //return new User(usuario.getEmail(),usuario.getPassword(), usuario.getRol());
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }
}

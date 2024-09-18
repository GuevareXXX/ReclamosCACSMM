package com.reclamos.security;

import com.reclamos.model.Rol;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class AppUserDetails implements UserDetails {
    private Integer id;
    private String indSocio;
    private Integer idTipoDoc;
    private String nroDoc;
    private String password;
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
    private Rol rol;
    private String username;

    private List<GrantedAuthority> grantedAuthorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public AppUserDetails(String nombre, String apePaterno, String apeMaterno, String email, String password, Rol rol,List<GrantedAuthority> grantedAuthorities) {
        this.nombre=nombre;
        this.apePaterno=apePaterno;
        this.apeMaterno=apeMaterno;
        this.email=email;
        this.password=password;
        this.rol=rol;
        this.grantedAuthorities = grantedAuthorities;
    }
}

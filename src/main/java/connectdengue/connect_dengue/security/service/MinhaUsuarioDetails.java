package connectdengue.connect_dengue.security.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import connectdengue.connect_dengue.model.Usuario;



public class MinhaUsuarioDetails implements UserDetails{

    private Usuario usuarioApp;

    public MinhaUsuarioDetails(Usuario meuUsuario){
        this.usuarioApp = meuUsuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return this.usuarioApp.getPassword();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return this.usuarioApp.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

    
    
}
package connectdengue.connect_dengue.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import connectdengue.connect_dengue.model.Usuario;
import connectdengue.connect_dengue.repository.UsuarioRepository;



public class MinhaUsuarioDetailsService implements UserDetailsService{

    @Autowired
    UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario userLogin = usuarioRepository.findByUsername(username);
        if(userLogin == null)
            throw new UsernameNotFoundException(username);
        return new MinhaUsuarioDetails(userLogin);
    }
    
}
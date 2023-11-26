package connectdengue.connect_dengue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import connectdengue.connect_dengue.model.Usuario;
import connectdengue.connect_dengue.repository.UsuarioRepository;

@RestController
public class ControllerUsuario {
    @Autowired
    UsuarioRepository usuarioRepository;

    // Deverá ser acessado só se a autenticação tiver sido realizada

    @Autowired
    PasswordEncoder passwordEncoder;

    // Deverá ser acessado independente de autenticação
    @PostMapping("/criar")
    public String criarUsuario(@RequestBody Usuario user) {
        user.setPassword(
                passwordEncoder.encode(user.getPassword()) // Codificando a senha enviada
        );
        Usuario usuarioCriado = usuarioRepository.save(user);

        if (usuarioCriado != null)
            return "Usuário criado com sucesso!";

        return "Erro ao criar usuário";

    }
    @GetMapping("/login")  
    public List<Usuario> verDengueShows() {

        return (List<Usuario>) usuarioRepository.findAll();
        
    }
}
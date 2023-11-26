package connectdengue.connect_dengue.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import connectdengue.connect_dengue.model.Sintomas;
import connectdengue.connect_dengue.repository.SintomasRepository;

@RestController
@CrossOrigin
public class ControllerSintomas {

    @Autowired
    SintomasRepository sintomasRepository;

    @GetMapping("/dengue/sintomas")
    public List<Sintomas> verSintomas() {

        return (List<Sintomas>) sintomasRepository.findAll();
    }

    @GetMapping("/dengue/sintomas/{id}")
    public Optional<Sintomas> verSintomasProcura(@PathVariable("id") long idSintomas) {

        if(sintomasRepository.existsById(idSintomas)){
            return sintomasRepository.findById(idSintomas);
        }else{
            return null;
        
    }
}

    @PostMapping("/dengue/sintomas/inserir")
    public List<Sintomas> incerirSintomasIncerir(@RequestBody List<Sintomas> sintomaList) {
        return (List<Sintomas>) sintomasRepository.saveAll(sintomaList);
        
    }


    @DeleteMapping("/dengue/sintomas/remove/{id}")
    public String removerSintomas(@PathVariable("id") long idSintomas) {
        
        if(sintomasRepository.existsById(idSintomas)){
            sintomasRepository.deleteById(idSintomas);
            return "Sintomas deletado com sucesso!";
        }else{
            return "ID não encontrado, por favor, insira outro ID";
        }
    
    }
}

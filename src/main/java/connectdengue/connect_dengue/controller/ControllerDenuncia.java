package connectdengue.connect_dengue.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import connectdengue.connect_dengue.model.Denuncia;
import connectdengue.connect_dengue.repository.DenunciasRepository;

@RestController
@CrossOrigin
public class ControllerDenuncia {

    @Autowired
    DenunciasRepository denunciasRepository;

    @GetMapping("/dengue/denuncias")
    public List<Denuncia> verDenuncias() {

        return (List<Denuncia>) denunciasRepository.findAll();
    }

    @GetMapping("/dengue/denuncias/{id}")
    public Optional<Denuncia> verDenunciasProcura(@PathVariable("id") long idDenuncia) {

        if(denunciasRepository.existsById(idDenuncia)){
            return denunciasRepository.findById(idDenuncia);
        }else{
            return null;
        }
    }

    @PostMapping("/dengue/denuncias/inserir")
    public List<Denuncia> inserirDenunciaInserir(@RequestBody List<Denuncia> denunciasList) {
        return (List<Denuncia>) denunciasRepository.saveAll(denunciasList);
    }

    @DeleteMapping("/dengue/denuncias/remove/{id}")
    public String removerDenuncia(@PathVariable("id") Long idDenuncia) {

        if(denunciasRepository.existsById(idDenuncia)){
            denunciasRepository.deleteById(idDenuncia);
            return "Denuncia deletada com sucesso!";
        }else{
            return "ID não encontrado, por favor, insira outro ID";
        }
        
    }
}

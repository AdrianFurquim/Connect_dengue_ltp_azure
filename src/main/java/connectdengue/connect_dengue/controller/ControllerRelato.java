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

import connectdengue.connect_dengue.model.Relato;
import connectdengue.connect_dengue.repository.RelatosRepository;

@RestController
@CrossOrigin
public class ControllerRelato {

    @Autowired
    RelatosRepository relatosRepository;

    @GetMapping("/dengue/relatos")
    public List<Relato> verRelatos() {

        return (List<Relato>) relatosRepository.findAll();
    }

    @GetMapping("/dengue/relatos/{id}")
    public Optional<Relato> verRelatosProcura(@PathVariable("id") long idRelato) {

        if (relatosRepository.existsById(idRelato)) {
            return relatosRepository.findById(idRelato);
        } else {
            return null;
        }
    }

    @PostMapping("/dengue/relatos/inserir")
    public List<Relato> incerirRelatoIncerir(@RequestBody List<Relato> relatosList) {

        return (List<Relato>) relatosRepository.saveAll(relatosList);
    }

    @DeleteMapping("/dengue/relatos/remove/{id}")
    public String removerRelato(@PathVariable("id") long idRelato) {

        if (relatosRepository.existsById(idRelato)) {
            relatosRepository.deleteById(idRelato);
            return "Relato deletado com sucesso!";
        } else {
            return "ID não encontrado, por favor, insira outro ID";
        }
    }

    
}

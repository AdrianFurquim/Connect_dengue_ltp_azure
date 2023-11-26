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

import connectdengue.connect_dengue.model.DengueShow;
import connectdengue.connect_dengue.repository.DengueShowRepository;

@RestController
@CrossOrigin
public class ControllerDengueShow {

    @Autowired
    DengueShowRepository dengueShowRepository;
    @GetMapping("/dengueshow/ver")  
    public List<DengueShow> verDengueShows() {

        return (List<DengueShow>) dengueShowRepository.findAll();
        // ANTIGO MÉTODO GET
        // DengueShowDAO quiz = DengueShowDAO.getInstance();
        // // DengueShow questionario = new DengueShow(1, null, 5);
        // // quiz.create(questionario);
        // List<DengueShow> quizes = quiz.findAll();
        // return quizes;
    }
    // GET COM DETALHAMENTO
    @GetMapping("/dengue/dengueShow/{id}")
    public Optional<DengueShow> verDengueShowProcura(@PathVariable("id") long idQuiz) {

        if(dengueShowRepository.existsById(idQuiz)){
            return dengueShowRepository.findById(idQuiz);
        }else{
            return null;
        }
    }

    @PostMapping("/dengueshow/inserir")
    public List<DengueShow> inserirQuizinserir(@RequestBody List<DengueShow> quizList) {
        return (List<DengueShow>) dengueShowRepository.saveAll(quizList);
    }
    // ANTIGO MÉTODO INSERIR
    // public DengueShow endPoint2(@RequestBody DengueShow questionario) {

    //     DengueShowDAO quizDados = DengueShowDAO.getInstance();
    //     List<DengueShow> quizes = quizDados.findAll();
    //     int existente = 0;
    //     for (DengueShow quizFor : quizes) {
    //         if(questionario.getIdQuiz() == quizFor.getIdQuiz()){
    //             existente++;
    //         }
    //     }
    //     if(existente > 0){
    //         return null;
    //     }else{
    //         quizDados.create(questionario);
    //         return questionario;
    //     }
        
    // }
    @DeleteMapping("/dengueshow/quiz/remove/{id}")
    public String removerQuiz(@PathVariable("id") Long idQuiz) {

        if(dengueShowRepository.existsById(idQuiz)){
            dengueShowRepository.deleteById(idQuiz);
            return "Quiz deletado com sucesso!";
        }else{
            return "ID não encontrado, por favor, insira o ID correto";
        }
        
    }
}

//  ANTIGO MÉTODO DELETE
//     public DengueShow removerQuestionario(@PathVariable("id") long idQuiz) {
        
//         DengueShowDAO quizDados = DengueShowDAO.getInstance();
//         List<DengueShow> quizes = quizDados.findAll();
//         for (DengueShow quiz : quizes) {
//             if(quiz.getIdQuiz() == idQuiz){
//                 quizDados.delete(quiz);
//                 return quiz;
//             }
//         }
//         return null;
//     }

// }

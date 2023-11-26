package connectdengue.connect_dengue;

import java.util.ArrayList;
import java.util.List;

import connectdengue.connect_dengue.model.DengueShow;



public class DatabaseDengueShow {
    public static ArrayList<DengueShow> quizes;

    public static void init(){
        quizes = new ArrayList<DengueShow>();
        quizes.add(new DengueShow("resposta1", "resposta2", "resposta3",  "resposta4",  "resposta5", 5));
    }

    public void addDadoDengueShow(DengueShow novo){
        quizes.add(novo);
    } 

    public static ArrayList<DengueShow> recuperarDadoQuiz(){
        return quizes;
    }

    public void removeDadosDengueShow(DengueShow delete){
        quizes.remove(delete);
    }
    public static List<DengueShow> all(){
        return quizes;
    }
}
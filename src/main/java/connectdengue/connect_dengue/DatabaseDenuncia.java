package connectdengue.connect_dengue;

import java.util.ArrayList;
import java.util.List;

import connectdengue.connect_dengue.model.Denuncia;

public class DatabaseDenuncia {
    public static ArrayList<Denuncia> denuncias;

    public static void init(){
        denuncias = new ArrayList<Denuncia>();
        denuncias.add(new Denuncia(244.00, 24.00, "Sao Paulo", "Itatiba"));
    }

    public void addDadoDenuncia(Denuncia novo){
        denuncias.add(novo);
    }

    public static ArrayList<Denuncia> recuperarDadoDenuncia(){
        return denuncias;
    }

    public void removeDadosDenuncia(Denuncia delete){
        denuncias.remove(delete);
    }
    public static List<Denuncia> all(){
        return denuncias;
    }
}

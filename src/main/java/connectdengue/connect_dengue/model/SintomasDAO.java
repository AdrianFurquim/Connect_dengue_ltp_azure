package connectdengue.connect_dengue.model;

import java.util.ArrayList;

import connectdengue.connect_dengue.DatabaseSintomas;




public class SintomasDAO {
    private DatabaseSintomas db;
    private static SintomasDAO instance;

    // O construtor privado garante que uma única instância irá existir
    private SintomasDAO(){
       
    }

    // Recupera a única instância do DAO
    public static SintomasDAO getInstance(){
        if(instance == null){
            instance = new SintomasDAO();
        }
        return instance;
    }

    // Recupera a conexão com o Banco de Dados
    private DatabaseSintomas getConnection(){
        if(this.db == null){            
            DatabaseSintomas db = new DatabaseSintomas();
            this.db = db;
        }
        return this.db;    
    }

    //Cria um novo cadastro
    public void create(Sintomas novo){
        DatabaseSintomas db = getConnection();
        db.addDadoSintomas(novo);
    }   

    // Recupera todas as listas
    public ArrayList<Sintomas> read(){
        DatabaseSintomas db = getConnection();
        return db.recuperarDadoSintomas();
    }

    public void delete(Sintomas delete){
        DatabaseSintomas db = getConnection();
        db.removeDadosSintomas(delete);
    }

    public void update(Sintomas toUpdate){
        // Sem implementação
    }

    public ArrayList<Sintomas> findAll(){
        //return (List<Sintomas>) Sint.all();
        return (ArrayList<Sintomas>) DatabaseSintomas.all();
    }
}

package connectdengue.connect_dengue.model;

import java.util.ArrayList;

import connectdengue.connect_dengue.DatabaseRelato;



public class RelatoDAO {

    private DatabaseRelato db;
    private static RelatoDAO instance;

    // O construtor privado garante que uma única instância irá existir
    private RelatoDAO(){
       
    }

    // Recupera a única instância do DAO
    public static RelatoDAO getInstance(){
        if(instance == null){
            instance = new RelatoDAO();
        }
        return instance;
    }

    // Recupera a conexão com o Banco de Dados
    private DatabaseRelato getConnection(){
        if(this.db == null){            
            DatabaseRelato db = new DatabaseRelato();
            this.db = db;
        }
        return this.db;    
    }

    //Cria um novo cadastro
    public void create(Relato novo){
        DatabaseRelato db = getConnection();
        db.addDadoRelato(novo);
    }   

    // Recupera todas as listas
    public ArrayList<Relato> read(){
        DatabaseRelato db = getConnection();
        return db.recuperarDadoRelato();
    }

    public void delete(Relato delete){
        DatabaseRelato db = getConnection();
        db.removeDadosRelato(delete);
    }

    public ArrayList<Relato> findAll(){
        //return (List<Relato>) Relato.all();
        return (ArrayList<Relato>) DatabaseRelato.all();
    }
}
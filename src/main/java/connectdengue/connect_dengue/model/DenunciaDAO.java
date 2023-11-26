package connectdengue.connect_dengue.model;

import java.util.ArrayList;

import connectdengue.connect_dengue.DatabaseDenuncia;



public class DenunciaDAO {

    private DatabaseDenuncia db;
    private static DenunciaDAO instance;

    // O construtor privado garante que uma única instância irá existir
    private DenunciaDAO(){
       
    }

    // Recupera a única instância do DAO
    public static DenunciaDAO getInstance(){
        if(instance == null){
            instance = new DenunciaDAO();
        }
        return instance;
    }

    // Recupera a conexão com o Banco de Dados
    private DatabaseDenuncia getConnection(){
        if(this.db == null){            
            DatabaseDenuncia db = new DatabaseDenuncia();
            this.db = db;
        }
        return this.db;    
    }

    //Cria um novo cadastro
    public void create(Denuncia novo){
        DatabaseDenuncia db = getConnection();
        db.addDadoDenuncia(novo);
    }   

    // Recupera todas as listas
    public ArrayList<Denuncia> read(){
        DatabaseDenuncia db = getConnection();
        return db.recuperarDadoDenuncia();
    }

    public void delete(Denuncia delete){
        DatabaseDenuncia db = getConnection();
        db.removeDadosDenuncia(delete);
    }

    public ArrayList<Denuncia> findAll(){
        //return (List<Denuncia>) Denuncia.all();
        return (ArrayList<Denuncia>) DatabaseDenuncia.all();
    }
}
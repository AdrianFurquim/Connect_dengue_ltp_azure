package connectdengue.connect_dengue.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Sintomas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSintomas;
    private String nome;
    private String descricao;
    private String intensidade;

    public Sintomas(){

    }
    
    public Sintomas( String nome, String descricao, String intensidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.intensidade = intensidade;
    }


    public long getIdSintomas() {
        return idSintomas;
    }


    public void setIdSintomas(long idSintomas) {
        this.idSintomas = idSintomas;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public String getIntensidade() {
        return intensidade;
    }


    public void setIntensidade(String intensidade) {
        this.intensidade = intensidade;
    }
     
}
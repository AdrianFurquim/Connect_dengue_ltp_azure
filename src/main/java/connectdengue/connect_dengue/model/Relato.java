package connectdengue.connect_dengue.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Relato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long idRelato;
    protected String nome;
    protected String experiencia;
    protected String localicacaoEstado;
    protected String relato;
    
    public Relato() {
    }

    public Relato(String nome, String experiencia, String localicacaoEstado, String relato) {
        this.nome = nome;
        this.experiencia = experiencia;
        this.localicacaoEstado = localicacaoEstado;
        this.relato = relato;
    }

    public long getIdRelato() {
        return idRelato;
    }

    public void setIdRelato(long idRelato) {
        this.idRelato = idRelato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getLocalicacaoEstado() {
        return localicacaoEstado;
    }

    public void setLocalicacaoEstado(String localicacaoEstado) {
        this.localicacaoEstado = localicacaoEstado;
    }

    public String getRelato() {
        return relato;
    }

    public void setRelato(String relato) {
        this.relato = relato;
    }

}

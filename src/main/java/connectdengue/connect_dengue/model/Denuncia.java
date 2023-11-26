package connectdengue.connect_dengue.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Denuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected double latitude;
    protected double longitude;
    protected String estado;
    protected String municipio;
    
    public Denuncia() {
    }

    public Denuncia(double latitude, double longitude, String estado, String municipio) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.estado = estado;
        this.municipio = municipio;
    }


    public double getLatitude() {
        return latitude;
    }


    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }


    public double getLongitude() {
        return longitude;
    }


    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    public String getMunicipio() {
        return municipio;
    }


    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
}
    


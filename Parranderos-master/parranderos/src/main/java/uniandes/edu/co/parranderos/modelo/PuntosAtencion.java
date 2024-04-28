package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PUNTOSATENCION")
public class PuntosAtencion {

    private String tipo;
    @Id
    private String localizacion;
    private String direccion;

    public PuntosAtencion() {;}

    public PuntosAtencion(String tipo, String localizacion, String direccion) {
        this.tipo = tipo;
        this.localizacion = localizacion;
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    
    

}


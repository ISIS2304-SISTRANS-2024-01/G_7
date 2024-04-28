package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="OFICINA")
public class Oficina {

    private String nombre;
    @Id
    private String direccion;
    private int numeroPuestosAtencion;

    public Oficina() {;}

    public Oficina(String nombre, String direccion, int numeroPuestosAtencion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroPuestosAtencion = numeroPuestosAtencion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumeroPuestosAtencion() {
        return numeroPuestosAtencion;
    }

    public void setNumeroPuestosAtencion(int numeroPuestosAtencion) {
        this.numeroPuestosAtencion = numeroPuestosAtencion;
    }

    
    
    

}


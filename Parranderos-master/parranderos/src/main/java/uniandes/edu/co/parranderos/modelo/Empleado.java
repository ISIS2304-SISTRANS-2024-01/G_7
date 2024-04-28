package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="EMPLEADO")
public class Empleado {
    
    private String rol;
    private String idEmpleado;
    @Id
    private int documentoIdentificacionNumero;
    private String direccion;
    
    public Empleado() {;}
    
    public Empleado(String rol, String idEmpleado, int documentoIdentificacionNumero, String direccion) {
        this.rol = rol;
        this.idEmpleado = idEmpleado;
        this.documentoIdentificacionNumero = documentoIdentificacionNumero;
        this.direccion = direccion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getDocumentoIdentificacionNumero() {
        return documentoIdentificacionNumero;
    }

    public void setDocumentoIdentificacionNumero(int documentoIdentificacionNumero) {
        this.documentoIdentificacionNumero = documentoIdentificacionNumero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    

}


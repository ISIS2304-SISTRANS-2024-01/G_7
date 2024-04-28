package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario {
    
    private String login;
    private String palabraClave;
    private String rol;
    private String documentoIdentificacionTipo;
    @Id
    private int documentoIdentificacionNumero;
    private String nombre;
    private String nacionalidad;
    private String direccionFisica;
    private String direccionElectronica;
    private int telefono;
    private String ciudad;
    private String departamento;
    private int codigoPostal;

    public Usuario() {;}

    public Usuario(String login, String palabraClave, String rol, String documentoIdentificacionTipo, int documentoIdentificacionNumero, String nombre, String nacionalidad, String direccionFisica, String direccionElectronica, int telefono, String ciudad, String departamento, int codigoPostal) {
        this.login = login;
        this.palabraClave = palabraClave;
        this.rol = rol;
        this.documentoIdentificacionTipo = documentoIdentificacionTipo;
        this.documentoIdentificacionNumero = documentoIdentificacionNumero;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.direccionFisica = direccionFisica;
        this.direccionElectronica = direccionElectronica;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.codigoPostal = codigoPostal;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPalabraClave() {
        return palabraClave;
    }

    public void setPalabraClave(String palabraClave) {
        this.palabraClave = palabraClave;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDocumentoIdentificacionTipo() {
        return documentoIdentificacionTipo;
    }

    public void setDocumentoIdentificacionTipo(String documentoIdentificacionTipo) {
        this.documentoIdentificacionTipo = documentoIdentificacionTipo;
    }

    public int getDocumentoIdentificacionNumero() {
        return documentoIdentificacionNumero;
    }

    public void setDocumentoIdentificacionNumero(int documentoIdentificacionNumero) {
        this.documentoIdentificacionNumero = documentoIdentificacionNumero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDireccionFisica() {
        return direccionFisica;
    }

    public void setDireccionFisica(String direccionFisica) {
        this.direccionFisica = direccionFisica;
    }

    public String getDireccionElectronica() {
        return direccionElectronica;
    }

    public void setDireccionElectronica(String direccionElectronica) {
        this.direccionElectronica = direccionElectronica;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    

}

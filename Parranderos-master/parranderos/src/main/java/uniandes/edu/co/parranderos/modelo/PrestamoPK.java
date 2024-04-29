package uniandes.edu.co.parranderos.modelo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PrestamoPK implements Serializable
{
    @Column(name = "idprestamo")
    private String idprestamo;

    @Column(name = "tipoprestamo")
    private String tipoprestamo;

    public PrestamoPK(String idprestamo, String tipoprestamo) 
    {
        super();
        this.idprestamo = idprestamo;
        this.tipoprestamo = tipoprestamo;
    }

    public PrestamoPK()
    {;}

    public String getIdprestamo() 
    {
        return idprestamo;
    }

    public void setIdprestamo(String idprestamo) 
    {
        this.idprestamo = idprestamo;
    }

    public String getTipoprestamo() 
    {
        return tipoprestamo;
    }

    public void setTipoprestamo(String tipoprestamo) 
    {
        this.tipoprestamo = tipoprestamo;
    }
    
    
}
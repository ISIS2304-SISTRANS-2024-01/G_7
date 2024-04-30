package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "operacionprestamo")
public class OperacionPrestamo
{
    @Id
    private Integer id;

   @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "idprestamo", referencedColumnName = "idprestamo"),
        @JoinColumn(name = "tipoprestamo", referencedColumnName = "tipoprestamo")
    })
    private Prestamo prestamo;

    private String numeroprestamo;


    public OperacionPrestamo(Integer id, String numeroprestamo, Prestamo prestamo) 
    {
        this.id = id;
        this.numeroprestamo = numeroprestamo;
        this.prestamo = prestamo;
    }

    public OperacionPrestamo()
    {;}

    public Integer getId() 
    {
        return id;
    }

    public String getNumeroprestamo() 
    {
        return numeroprestamo;
    }

    public void setNumeroprestamo(String numeroprestamo) 
    {
        this.numeroprestamo = numeroprestamo;
    }

    // public Prestamo getprestamo() 
    // {
    //     return prestamo;
    // }

    // public void setprestamo(Prestamo idprestamo) 
    // {
    //     this.prestamo = idprestamo;
    // }

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Prestamo getPrestamo() 
    {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) 
    {
        this.prestamo = prestamo;
    }

    
}
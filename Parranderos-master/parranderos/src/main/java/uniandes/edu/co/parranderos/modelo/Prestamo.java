package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne; 
import jakarta.persistence.Table;

@Entity
@Table(name="prestamo")
public class Prestamo 
{
    @EmbeddedId
    private PrestamoPK prestamoPK;

    private String estado;
    private Double monto;
    private Double intereses;
    private Integer numcuotas;
    private String mespago;
    private Double valorcuota;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Cliente id;

    // @OneToMany(mappedBy = "idprestamo")
    // //@JoinColumn(name = )
    // private List<OperacionPrestamo> operacionesPrestamo;

    // @OneToMany(mappedBy = "tipoprestamo")
    // private List<OperacionPrestamo> operacionesTipoPrestamo;



    public Prestamo(String estado, Double monto, Double intereses, Integer numcuotas, String mespago, Double valorcuota, Cliente id) 
    {
        this.prestamoPK = new PrestamoPK();
        this.estado = estado;
        this.monto = monto;
        this.intereses = intereses;
        this.numcuotas = numcuotas;
        this.mespago = mespago;
        this.valorcuota = valorcuota;
        this.id = id;
    }
    
    public Prestamo()
    {;}

    public String getEstado() 
    {
        return estado;
    }

    public Double getMonto() 
    {
        return monto;
    }

    public Double getIntereses() 
    {
        return intereses;
    }

    public Integer getNumcuotas() 
    {
        return numcuotas;
    }

    public String getMespago() 
    {
        return mespago;
    }

    public Double getValorcuota() 
    {
        return valorcuota;
    }

    public void setEstado(String estado) 
    {
        this.estado = estado;
    }

    public void setMonto(Double monto) 
    {
        this.monto = monto;
    }

    public void setIntereses(Double intereses) 
    {
        this.intereses = intereses;
    }

    public void setNumcuotas(Integer numCuotas) 
    {
        this.numcuotas = numCuotas;
    }

    public void setMespago(String mesPago) 
    {
        this.mespago = mesPago;
    }

    public void setValorcuota(Double valorCuota) 
    {
        this.valorcuota = valorCuota;
    }

    public Cliente getId() 
    {
        return id;
    }

    public void setId(Cliente id) 
    {
        this.id = id;
    }
}
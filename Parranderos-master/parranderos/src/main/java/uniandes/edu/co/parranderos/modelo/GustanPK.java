package uniandes.edu.co.parranderos.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Embeddable
public class GustanPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_bebedor", referencedColumnName = "id")
    private Bebedor id_bebedor;

    @ManyToOne
    @JoinColumn(name = "id_bebida", referencedColumnName = "id")
    private Bebida id_bebida;

    public GustanPK(Bebedor id_bebedor, Bebida id_bebida) {
        super();
        this.id_bebedor = id_bebedor;
        this.id_bebida = id_bebida;
    }

    public Bebedor getId_bebedor() {
        return id_bebedor;
    }

    public Bebida getId_bebida() {
        return id_bebida;
    }

    public void setId_bebedor(Bebedor id_bebedor) {
        this.id_bebedor = id_bebedor;
    }

    public void setId_bebida(Bebida id_bebida) {
        this.id_bebida = id_bebida;
    }
}

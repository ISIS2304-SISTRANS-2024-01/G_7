package uniandes.edu.co.parranderos.modelo;
import java.sql.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="frecuentan")
public class Frecuentan {

    @EmbeddedId
    private FrecuentanPK pk;

    public Frecuentan(){;}

    public Frecuentan(Bebedor id_bebedor, Bar id_bar, Date fecha_visita, String horario)
    {
        this.pk = new FrecuentanPK(id_bebedor, id_bar, fecha_visita, horario);
    }

    public FrecuentanPK getPk() {
        return pk;
    }

    public void setPk(FrecuentanPK pk) {
        this.pk = pk;
    }

}

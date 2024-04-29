package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PUNTOSATENCION")
public class PuntosAtencion {

    private String TIPO;
    @Id
    private String LOCALIZACION;
    private String DIRECCION;
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private int ID;

    public PuntosAtencion() {;}

    public PuntosAtencion(String tIPO, String lOCALIZACION, String dIRECCION) {
        TIPO = tIPO;
        LOCALIZACION = lOCALIZACION;
        DIRECCION = dIRECCION;
    }

    public String getTIPO() {
        return TIPO;
    }

    public void setTIPO(String tIPO) {
        TIPO = tIPO;
    }

    public String getLOCALIZACION() {
        return LOCALIZACION;
    }

    public void setLOCALIZACION(String lOCALIZACION) {
        LOCALIZACION = lOCALIZACION;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String dIRECCION) {
        DIRECCION = dIRECCION;
    }

    public int getID() {
        return ID;
    }

    
    

}


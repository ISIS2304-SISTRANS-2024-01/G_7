package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="OFICINA")
public class Oficina {

    private String NOMBRE;
    @Id
    private String DIRECCION;
    private int NUMPUESTOSATENCION;

    public Oficina() {;}

    public Oficina(String nOMBRE, String dIRECCION, int nUMPUESTOSATENCION) {
        NOMBRE = nOMBRE;
        DIRECCION = dIRECCION;
        NUMPUESTOSATENCION = nUMPUESTOSATENCION;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String nOMBRE) {
        NOMBRE = nOMBRE;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String dIRECCION) {
        DIRECCION = dIRECCION;
    }

    public int getNUMPUESTOSATENCION() {
        return NUMPUESTOSATENCION;
    }

    public void setNUMPUESTOSATENCION(int nUMPUESTOSATENCION) {
        NUMPUESTOSATENCION = nUMPUESTOSATENCION;
    }

    
    
    

}


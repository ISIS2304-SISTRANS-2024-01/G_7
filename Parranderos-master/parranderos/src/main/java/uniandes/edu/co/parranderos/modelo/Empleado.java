package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="EMPLEADO")
public class Empleado {
    
    private String ROL;
    private String IDEMPLEADO;
    @Id
    private int DOCUMENTOIDENTIFICACIONNUMERO;
    private String DIRECCION;
    
    public Empleado() {;}

    public Empleado(String rOL, String iDEMPLEADO, int dOCUMENTOIDENTIFICACIONNUMERO, String dIRECCION) {
        ROL = rOL;
        IDEMPLEADO = iDEMPLEADO;
        DOCUMENTOIDENTIFICACIONNUMERO = dOCUMENTOIDENTIFICACIONNUMERO;
        DIRECCION = dIRECCION;
    }

    public String getROL() {
        return ROL;
    }

    public void setROL(String rOL) {
        ROL = rOL;
    }

    public String getIDEMPLEADO() {
        return IDEMPLEADO;
    }

    public void setIDEMPLEADO(String iDEMPLEADO) {
        IDEMPLEADO = iDEMPLEADO;
    }

    public int getDOCUMENTOIDENTIFICACIONNUMERO() {
        return DOCUMENTOIDENTIFICACIONNUMERO;
    }

    public void setDOCUMENTOIDENTIFICACIONNUMERO(int dOCUMENTOIDENTIFICACIONNUMERO) {
        DOCUMENTOIDENTIFICACIONNUMERO = dOCUMENTOIDENTIFICACIONNUMERO;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String dIRECCION) {
        DIRECCION = dIRECCION;
    }
    
    

    

}


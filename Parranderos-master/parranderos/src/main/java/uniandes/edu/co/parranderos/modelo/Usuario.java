package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario {
    
    private String LOGIN;
    private String PALABRACLAVE;
    private String ROL;
    private String DOCUMENTOIDENTIFICACIONTIPO;
    @Id
    private int DOCUMENTOIDENTIFICACIONNUMERO;
    private String NOMBRE;
    private String NACIONALIDAD;
    private String DIRECCIONFISICA;
    private String DIRECCIONELECTRONICA;
    private int TELEFONO;
    private String CIUDAD;
    private String DEPARTAMENTO;
    private int CODIGOPOSTAL;

    public Usuario() {;}

    

    public Usuario(String lOGIN, String pALABRACLAVE, String rOL, String dOCUMENTOIDENTIFICACIONTIPO,
            int dOCUMENTOIDENTIFICACIONNUMERO, String nOMBRE, String nACIONALIDAD, String dIRECCIONFISICA,
            String dIRECCIONELECTRONICA, int tELEFONO, String cIUDAD, String dEPARTAMENTO, int cODIGOPOSTAL) {
        LOGIN = lOGIN;
        PALABRACLAVE = pALABRACLAVE;
        ROL = rOL;
        DOCUMENTOIDENTIFICACIONTIPO = dOCUMENTOIDENTIFICACIONTIPO;
        DOCUMENTOIDENTIFICACIONNUMERO = dOCUMENTOIDENTIFICACIONNUMERO;
        NOMBRE = nOMBRE;
        NACIONALIDAD = nACIONALIDAD;
        DIRECCIONFISICA = dIRECCIONFISICA;
        DIRECCIONELECTRONICA = dIRECCIONELECTRONICA;
        TELEFONO = tELEFONO;
        CIUDAD = cIUDAD;
        DEPARTAMENTO = dEPARTAMENTO;
        CODIGOPOSTAL = cODIGOPOSTAL;
    }



    public String getLOGIN() {
        return LOGIN;
    }



    public void setLOGIN(String lOGIN) {
        LOGIN = lOGIN;
    }



    public String getPALABRACLAVE() {
        return PALABRACLAVE;
    }



    public void setPALABRACLAVE(String pALABRACLAVE) {
        PALABRACLAVE = pALABRACLAVE;
    }



    public String getROL() {
        return ROL;
    }



    public void setROL(String rOL) {
        ROL = rOL;
    }



    public String getDOCUMENTOIDENTIFICACIONTIPO() {
        return DOCUMENTOIDENTIFICACIONTIPO;
    }



    public void setDOCUMENTOIDENTIFICACIONTIPO(String dOCUMENTOIDENTIFICACIONTIPO) {
        DOCUMENTOIDENTIFICACIONTIPO = dOCUMENTOIDENTIFICACIONTIPO;
    }



    public int getDOCUMENTOIDENTIFICACIONNUMERO() {
        return DOCUMENTOIDENTIFICACIONNUMERO;
    }



    public void setDOCUMENTOIDENTIFICACIONNUMERO(int dOCUMENTOIDENTIFICACIONNUMERO) {
        DOCUMENTOIDENTIFICACIONNUMERO = dOCUMENTOIDENTIFICACIONNUMERO;
    }



    public String getNOMBRE() {
        return NOMBRE;
    }



    public void setNOMBRE(String nOMBRE) {
        NOMBRE = nOMBRE;
    }



    public String getNACIONALIDAD() {
        return NACIONALIDAD;
    }



    public void setNACIONALIDAD(String nACIONALIDAD) {
        NACIONALIDAD = nACIONALIDAD;
    }



    public String getDIRECCIONFISICA() {
        return DIRECCIONFISICA;
    }



    public void setDIRECCIONFISICA(String dIRECCIONFISICA) {
        DIRECCIONFISICA = dIRECCIONFISICA;
    }



    public String getDIRECCIONELECTRONICA() {
        return DIRECCIONELECTRONICA;
    }



    public void setDIRECCIONELECTRONICA(String dIRECCIONELECTRONICA) {
        DIRECCIONELECTRONICA = dIRECCIONELECTRONICA;
    }



    public int getTELEFONO() {
        return TELEFONO;
    }



    public void setTELEFONO(int tELEFONO) {
        TELEFONO = tELEFONO;
    }



    public String getCIUDAD() {
        return CIUDAD;
    }



    public void setCIUDAD(String cIUDAD) {
        CIUDAD = cIUDAD;
    }



    public String getDEPARTAMENTO() {
        return DEPARTAMENTO;
    }



    public void setDEPARTAMENTO(String dEPARTAMENTO) {
        DEPARTAMENTO = dEPARTAMENTO;
    }



    public int getCODIGOPOSTAL() {
        return CODIGOPOSTAL;
    }



    public void setCODIGOPOSTAL(int cODIGOPOSTAL) {
        CODIGOPOSTAL = cODIGOPOSTAL;
    }

    

  

    

}

package uniandes.edu.co.parranderos.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CUENTAS")
public class Cuenta {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)  
    private Integer NUMEROCUENTA;

    private String TIPO;

    private Integer SALDO;

    private Date FECHAULTIMATRANSACCION;

    private String ESTADO;

    private Integer DOCUMENTOIDENTIFICACIONNUMERO;

    public Cuenta()
    {;}

    public Cuenta(String TIPO, Integer SALDO, Date FECHAULTIMATRANSACCION, String ESTADO, Integer DOCUMENTOIDENTIDICACION)
    {
    this.TIPO = TIPO;
    this.SALDO = SALDO;
    this.FECHAULTIMATRANSACCION = FECHAULTIMATRANSACCION;
    this.ESTADO = ESTADO;
    this.DOCUMENTOIDENTIFICACIONNUMERO = DOCUMENTOIDENTIDICACION;
    }

    public Integer getNUMEROCUENTA() {
        return NUMEROCUENTA;
    }

    public String getTIPO() {
        return TIPO;
    }

    public Integer getSALDO() {
        return SALDO;
    }

    public Date getFECHAULTIMATRANSACCION() {
        return FECHAULTIMATRANSACCION;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public Integer getDOCUMENTOIDENTIFICACIONNUMERO() {
        return DOCUMENTOIDENTIFICACIONNUMERO;
    }

    public void setNUMEROCUENTA(Integer nUMEROCUENTA) {
        NUMEROCUENTA = nUMEROCUENTA;
    }

    public void setTIPO(String tIPO) {
        TIPO = tIPO;
    }

    public void setSALDO(Integer sALDO) {
        SALDO = sALDO;
    }

    public void setFECHAULTIMATRANSACCION(Date fECHAULTIMATRANSACCION) {
        FECHAULTIMATRANSACCION = fECHAULTIMATRANSACCION;
    }

    public void setESTADO(String eSTADO) {
        ESTADO = eSTADO;
    }

    public void setDOCUMENTOIDENTIFICACIONNUMERO(Integer dOCUMENTOIDENTIDICACION) {
        DOCUMENTOIDENTIFICACIONNUMERO = dOCUMENTOIDENTIDICACION;
    }

}
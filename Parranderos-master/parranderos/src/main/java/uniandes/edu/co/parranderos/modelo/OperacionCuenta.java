package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CUENTAS")
public class OperacionCuenta {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)  
    private Integer ID;

    private String TIPOPAGO;

    private Integer NUMEROCUENTAAFECTADA;

    private Integer NUMEROCUENTA;

    public OperacionCuenta()
    {;}

    public OperacionCuenta(Integer ID, String TIPOPAGO, Integer NUMEROCUENTAAFECTADA, Integer NUMEROCUENTA)
    {
    this.ID = ID;
    this.TIPOPAGO = TIPOPAGO;
    this.NUMEROCUENTAAFECTADA = NUMEROCUENTAAFECTADA;
    this.NUMEROCUENTA = NUMEROCUENTA;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer iD) {
        ID = iD;
    }

    public String getTIPOPAGO() {
        return TIPOPAGO;
    }

    public void setTIPOPAGO(String tIPOPAGO) {
        TIPOPAGO = tIPOPAGO;
    }

    public Integer getNUMEROCUENTAAFECTADA() {
        return NUMEROCUENTAAFECTADA;
    }

    public void setNUMEROCUENTAAFECTADA(Integer nUMEROCUENTAAFECTADA) {
        NUMEROCUENTAAFECTADA = nUMEROCUENTAAFECTADA;
    }

    public Integer getNUMEROCUENTA() {
        return NUMEROCUENTA;
    }

    public void setNUMEROCUENTA(Integer nUMEROCUENTA) {
        NUMEROCUENTA = nUMEROCUENTA;
    }

    

}
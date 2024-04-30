package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CLIENTE")
public class Cliente {

    @Id
    private int ID;
    private String TIPOCLIENTE;
    
    public Cliente() {;}

    public Cliente(int iD, String tIPOCLIENTE) {
        ID = iD;
        TIPOCLIENTE = tIPOCLIENTE;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getTIPOCLIENTE() {
        return TIPOCLIENTE;
    }

    public void setTIPOCLIENTE(String tIPOCLIENTE) {
        TIPOCLIENTE = tIPOCLIENTE;
    }

    
    
    

}


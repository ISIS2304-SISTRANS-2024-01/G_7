package com.example.demo.modelo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PuntosAtencion")
public class PuntosAtencion {
    private String TIPO;
    private String OPERACIONESVALIDAS;
    private String OFICINA;

    public PuntosAtencion() {
        ;
    }

    public PuntosAtencion(String tIPO, String tOPERACIONESVALIDAS, String tOFICINA) {
        TIPO = tIPO;
        OPERACIONESVALIDAS = tOPERACIONESVALIDAS;
        OFICINA = tOFICINA;
    }

    public String getTIPO() {
        return TIPO;
    }

    public void setTIPO(String tIPO) {
        TIPO = tIPO;
    }

    public String getOPERACIONESVALIDAS() {
        return OPERACIONESVALIDAS;
    }

    public void setOPERACIONESVALIDAS(String oPERACIONESVALIDAS) {
        OPERACIONESVALIDAS = oPERACIONESVALIDAS;
    }

    public String getOFICINA() {
        return OFICINA;
    }

    public void setOFICINA(String oFICINA) {
        OFICINA = oFICINA;
    }
}
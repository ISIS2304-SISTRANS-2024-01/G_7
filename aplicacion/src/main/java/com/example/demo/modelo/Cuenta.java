package com.example.demo.modelo;

import java.sql.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "cuenta")
public class Cuenta 
{
    
    @Id
    private String id;
    private String tipo;
    private String estado;
    private String numeroCuenta;
    private float saldo;
    private Date fecha_ultima_transaccion;
    private Date fecha_creaccion;
    private List<OperacionCuenta> operaciones_cuenta;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    public Date getFecha_ultima_transaccion() {
        return fecha_ultima_transaccion;
    }
    public void setFecha_ultima_transaccion(Date fecha_ultima_transaccion) {
        this.fecha_ultima_transaccion = fecha_ultima_transaccion;
    }
    public Date getFecha_creaccion() {
        return fecha_creaccion;
    }
    public void setFecha_creaccion(Date fecha_creaccion) {
        this.fecha_creaccion = fecha_creaccion;
    }
    public List<OperacionCuenta> getOperaciones_cuenta() {
        return operaciones_cuenta;
    }
    public void setOperaciones_cuenta(List<OperacionCuenta> operaciones_cuenta) {
        this.operaciones_cuenta = operaciones_cuenta;
    }
}

class OperacionCuenta 
{
    private int _id;
    private String tipo;
    private String cuenta_afectada;
    private double valor;
    private Date fecha;
    private List<PuntoAtencion> punto_atencion;


    public int get_id() {
        return _id;
    }
    public void set_id(int _id) {
        this._id = _id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getCuenta_afectada() {
        return cuenta_afectada;
    }
    public void setCuenta_afectada(String cuenta_afectada) {
        this.cuenta_afectada = cuenta_afectada;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public List<PuntoAtencion> getPunto_atencion() {
        return punto_atencion;
    }
    public void setPunto_atencion(List<PuntoAtencion> punto_atencion) {
        this.punto_atencion = punto_atencion;
    }
}


class PuntoAtencion 
{
    private String tipo;
    private List<String> operaciones_validas;
    private ObjectId oficina;

    public String getTipo() 
    {
        return tipo;
    }
    public void setTipo(String tipo) 
    {
        this.tipo = tipo;
    }
    public List<String> getOperaciones_validas() 
    {
        return operaciones_validas;
    }
    public void setOperaciones_validas(List<String> operaciones_validas) 
    {
        this.operaciones_validas = operaciones_validas;
    }
    public ObjectId getOficina() 
    {
        return oficina;
    }
    public void setOficina(ObjectId oficina) 
    {
        this.oficina = oficina;
    }
}
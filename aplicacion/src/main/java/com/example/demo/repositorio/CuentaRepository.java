package com.example.demo.repositorio;

import java.sql.Date;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import com.example.demo.modelo.Cuenta;

public interface CuentaRepository extends MongoRepository<Cuenta, String>
{
    @Query("{tipo: ?0, estado: ?1, numeroCuenta: ?2, saldo: ?3, fecha_ultima_transaccion: ?4, fecha_creaccion: ?5, operaciones_cuenta: [ null ] }")
    void insertarCuenta(String tipo, String estado, String numeroCuenta, float saldo, Date fecha_ultima_transaccion, Date fecha_creaccion);

    @Query("{numeroCuenta: ?0}")
    @Update("{ '$set': { estado: 'Cerrada' }}")
    void CerrarCuenta(String numeroCuenta);
      
    @Query("{numeroCuenta: ?0}")
    @Update("{ '$set': { estado: 'Desactivada' }}")
    void DesactivarCuenta(String numeroCuenta);

}
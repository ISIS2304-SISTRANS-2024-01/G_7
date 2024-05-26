package com.example.demo.repositorio;

import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import com.example.demo.modelo.Cuenta;
import com.example.demo.modelo.PuntoAtencion;

public interface CuentaRepository extends MongoRepository<Cuenta, String>
{

    @Query("{numeroCuenta: ?0}")
    Cuenta findByNumeroCuenta(String numeroCuenta);

    @Query("{tipo: ?0, estado: ?1, numeroCuenta: ?2, saldo: ?3, fecha_ultima_transaccion: ?4, fecha_creacion: ?5, operaciones_cuenta: [ null ] }")
    Cuenta insertarCuenta(String tipo, String estado, String numeroCuenta, int saldo, Date fecha_ultima_transaccion, Date fecha_creacion);

    @Query("{numeroCuenta: ?0}")
    @Update("{ '$set': { estado: 'Cerrada' }}")
    void cerrarCuenta(String numeroCuenta);
      
    @Query("{numeroCuenta: ?0}")
    @Update("{ '$set': { estado: 'Desactivada' }}")
    void desactivarCuenta(String numeroCuenta);

    @Query("{'numeroCuenta': '123' }, { $push: { 'operaciones_cuenta.$.punto_atencion': ?0 } }")
    PuntoAtencion insertarPuntoAtencion(PuntoAtencion puntoAtencion);


}
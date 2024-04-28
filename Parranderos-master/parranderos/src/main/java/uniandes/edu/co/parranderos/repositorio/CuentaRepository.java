package uniandes.edu.co.parranderos.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.Cuenta;

import java.sql.Date;


public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO CUENTAS (NUMEROCUENTA, TIPO, SALDO, FECHAULTIMATRANSACCION, ESTADO, DOCUMENTOIDENTIFICACIONNUMERO) VALUES ( :NUMEROCUENTA, :TIPO, :SALDO, :FECHAULTIMATRANSACCION, :ESTADO, :DOCUMENTOIDENTIFICACIONNUMERO)", nativeQuery = true)
        void insertarCuenta(@Param("NUMEROCUENTA") Integer NUMEROCUENTA, @Param("TIPO") String TIPO, @Param("SALDO") Integer SALDO,
                        @Param("FECHAULTIMATRANSACCION") Date FECHAULTIMATRANSACCION, @Param("ESTADO") String ESTADO, @Param("DOCUMENTOIDENTIFICACIONNUMERO") Integer DOCUMENTOIDENTIDICACIONNUMERO);

        @Modifying
        @Transactional
        @Query(value = "UPDATE CUENTAS SET ESTADO = 'Cerrada' WHERE NUMEROCUENTA = :NUMEROCUENTA; AND SALDO = 0", nativeQuery = true)
        void actualizarCuenta(@Param("NUMEROCUENTA") Integer NUMEROCUENTA, @Param("ESTADO") String ESTADO,
                        @Param("SALDO") Integer SALDO);
}

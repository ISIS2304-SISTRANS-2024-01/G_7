package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

        
        @Query(value = "SELECT C.SALDO, C.FECHAULTIMATRACCION, C.ESTADO FROM CUENTA C INNERJOIN OPERACIONCUENTA OC ON C.NUMEROCUENTA = OC.NUMEROCUENTA "+//
                        "WHERE C.NUMEROCUENTA = :NUMEROCUENTA", nativeQuery = true)
        Collection<Cuenta> extractoBancarioCuenta(@Param("NUMEROCUENTA") Integer NUMEROCUENTA, @Param("MES") Date MES);

}

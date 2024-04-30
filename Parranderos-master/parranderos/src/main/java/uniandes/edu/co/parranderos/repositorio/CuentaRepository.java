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
import java.util.Collection;


public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

        @Query(value="SELECT * FROM CUENTA", nativeQuery = true)
        Collection<Cuenta> darCuentas();

        @Query(value="SELECT * FROM CUENTA WHERE TIPO=:TIPO AND (SALDO BETWEEN :SALDOINICIAL AND :SALDOFINAL) AND DOCUMENTOIDENTIFICACIONNUMERO=:DOCUMENTOIDENTIFICACIONNUMERO", nativeQuery = true)
        Cuenta darCuentaRFC1(@Param("TIPO") String TIPO, @Param("SALDOINICIAL") Integer SALDOINICIAL, @Param("SALDOFINAL") Integer SALDOFINAL, @Param("DOCUMENTOIDENTIFICACIONNUMERO") Integer DOCUMENTOIDENTIFICACIONNUMERO);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO CUENTA (NUMEROCUENTA, TIPO, SALDO, FECHAULTIMATRANSACCION, ESTADO, DOCUMENTOIDENTIFICACIONNUMERO) VALUES ( :NUMEROCUENTA, :TIPO, :SALDO, :FECHAULTIMATRANSACCION, :ESTADO, :DOCUMENTOIDENTIFICACIONNUMERO)", nativeQuery = true)
        void insertarCuenta(@Param("NUMEROCUENTA") Integer NUMEROCUENTA, @Param("TIPO") String TIPO, @Param("SALDO") Integer SALDO,
                        @Param("FECHAULTIMATRANSACCION") Date FECHAULTIMATRANSACCION, @Param("ESTADO") String ESTADO, @Param("DOCUMENTOIDENTIFICACIONNUMERO") Integer DOCUMENTOIDENTIFICACIONNUMERO);

        /* 
        @Modifying
        @Transactional
        @Query(value = "UPDATE CUENTA SET ESTADO = 'Cerrada' WHERE NUMEROCUENTA = :NUMEROCUENTA; AND SALDO = 0", nativeQuery = true)
        void actualizarCuenta(@Param("NUMEROCUENTA") Integer NUMEROCUENTA, @Param("ESTADO") String ESTADO,
                        @Param("SALDO") Integer SALDO);
        */
}

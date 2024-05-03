package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;
import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import uniandes.edu.co.parranderos.modelo.Cuenta;
import uniandes.edu.co.parranderos.modelo.OperacionCuenta;

public interface OperacionCuentaRepository extends JpaRepository<Cuenta, Integer> 
{
        @Query(value = "SELECT * FROM operacioncuenta WHERE id = :id", nativeQuery = true)
        OperacionCuenta darOperacionPrestamo(@Param("id") Integer id);

        public interface RespuestaInformacionCuenta {
                ArrayList<Integer> getOperacionenCuenta();                
        }

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO operacioncuenta (ID, TIPOPAGO, NUMEROCUENTAAFECTADA, NUMEROCUENTA) VALUES (:ID, :TIPOPAGO, :NUMEROCUENTAAFECTADA, :NUMEROCUENTA);", nativeQuery = true)
        void insertarOperacionCuenta(@Param("ID") Integer ID, @Param("TIPOPAGO") String TIPOPAGO, @Param("NUMEROCUENTAAFECTADA") Integer NUMEROCUENTAAFECTADA,
                        @Param("NUMEROCUENTA") Integer NUMEROCUENTA);
                
        @Query(value = "INSERT INTO log_operaciones_cuentas (TIPOPAGO, NUMEROCUENTAAFECTADA, NUMEROCUENTA) VALUES ('Retiro', :cuentaOrigen, :cuentaOrigen)", nativeQuery = true)
        void registrarOperacionRetiro(@Param("cuentaOrigen") Integer cuentaOrigen);

        @Modifying
        @Transactional
        @Query(value = "UPDATE cuenta SET saldo = saldo - :monto WHERE numero = :cuentaOrigen", nativeQuery = true)
        void retirarDinero(@Param("monto") double monto, @Param("cuentaOrigen") Integer cuentaOrigen);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO log_operaciones_cuentas (TIPOPAGO, NUMEROCUENTAAFECTADA, NUMEROCUENTA) VALUES (:TIPOPAGO, :NUMEROCUENTAAFECTADA, :NUMEROCUENTA)", nativeQuery = true)
        void consignarOperacionCuenta(@Param("TIPOPAGO") String TIPOPAGO, @Param("NUMEROCUENTAAFECTADA") Integer NUMEROCUENTAAFECTADA, @Param("NUMEROCUENTA") Integer NUMEROCUENTA);

        @Modifying
        @Transactional
        @Query(value = "UPDATE cuenta SET saldo = saldo + :monto WHERE numero = :numeroCuenta", nativeQuery = true)
        void consignar(@Param("monto") double monto, @Param("numeroCuenta") Integer numeroCuenta);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO log_operaciones_cuentas (TIPOPAGO, NUMEROCUENTAAFECTADA, NUMEROCUENTA) VALUES ('Transferencia', :cuentaDestino, :cuentaOrigen)", nativeQuery = true)
        void registrarOperacionTransferencia(@Param("cuentaOrigen") Integer cuentaOrigen, @Param("cuentaDestino") Integer cuentaDestino);

        @Modifying
        @Transactional
        @Query(value = "UPDATE cuenta SET saldo = saldo - :monto WHERE numero = :cuentaOrigen", nativeQuery = true)
        void restarSaldoOrigen(@Param("monto") double monto, @Param("cuentaOrigen") Integer cuentaOrigen);

        @Modifying
        @Transactional
        @Query(value = "UPDATE cuenta SET saldo = saldo + :monto WHERE numero = :cuentaDestino", nativeQuery = true)
        void sumarSaldoDestino(@Param("monto") double monto, @Param("cuentaDestino") Integer cuentaDestino);


        @Modifying
        @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
        @Query(value = "SELECT OC.ID, OC.TIPOPAGO FROM OPERACIONCUENTA OC WHERE OC.NUMEROCUENTA = :NUMEROCUENTA", nativeQuery = true)
        Collection<RespuestaInformacionCuenta> darInformacionOperacionesCuentaRC(@Param("NUMEROCUENTA") Integer NUMEROCUENTA);

        @Modifying
        @Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
        @Query(value = "SELECT OC.ID, OC.TIPOPAGO FROM OPERACIONCUENTA OC WHERE OC.NUMEROCUENTA = :NUMEROCUENTA", nativeQuery = true)
        Collection<RespuestaInformacionCuenta> darInformacionOperacionesCuentaSE(@Param("NUMEROCUENTA") Integer NUMEROCUENTA);
}

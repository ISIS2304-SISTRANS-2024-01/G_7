package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;
import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import uniandes.edu.co.parranderos.modelo.Cuenta;
import uniandes.edu.co.parranderos.modelo.OperacionCuenta;


public interface OperacionCuentaRepository extends JpaRepository<Cuenta, Integer> {

        public interface RespuestaInformacionCuenta {
                ArrayList<Integer> getOperacionenCuenta();                
        }

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO operacioncuenta (ID, TIPOPAGO, NUMEROCUENTAAFECTADA, NUMEROCUENTA) VALUES (:ID, :TIPOPAGO, :NUMEROCUENTAAFECTADA, :NUMEROCUENTA);", nativeQuery = true)
        void insertarOperacionCuenta(@Param("ID") Integer ID, @Param("TIPOPAGO") String TIPOPAGO, @Param("NUMEROCUENTAAFECTADA") Integer NUMEROCUENTAAFECTADA,
                        @Param("NUMEROCUENTA") Integer NUMEROCUENTA);
        @Query(value = "SELECT OC.ID, OC.TIPOPAGO FROM OPERACIONCUENTA OC WHERE OC.NUMEROCUENTA = :NUMEROCUENTA", nativeQuery = true)
        Collection<RespuestaInformacionCuenta> darInformacionOperacionesCuenta();
}

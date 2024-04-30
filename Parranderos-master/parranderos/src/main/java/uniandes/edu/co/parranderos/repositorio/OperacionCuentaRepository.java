package uniandes.edu.co.parranderos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.Cuenta;
import uniandes.edu.co.parranderos.modelo.OperacionCuenta;

public interface OperacionCuentaRepository extends JpaRepository<Cuenta, Integer> 
{
        @Query(value = "SELECT * FROM operacioncuenta WHERE id = :id", nativeQuery = true)
        OperacionCuenta darOperacionPrestamo(@Param("id") Integer id);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO operacioncuenta (ID, TIPOPAGO, NUMEROCUENTAAFECTADA, NUMEROCUENTA) VALUES (:ID, :TIPOPAGO, :NUMEROCUENTAAFECTADA, :NUMEROCUENTA);", nativeQuery = true)
        void insertarOperacionCuenta(@Param("ID") Integer ID, @Param("TIPOPAGO") String TIPOPAGO, @Param("NUMEROCUENTAAFECTADA") Integer NUMEROCUENTAAFECTADA, @Param("NUMEROCUENTA") Integer NUMEROCUENTA);

        @Modifying
        @Transactional
        default void retirarDinero(Integer ID, String tipoPago, Integer numeroCuentaAfectada, Integer numeroCuenta) 
        {
                insertarOperacionCuenta(ID, tipoPago, numeroCuentaAfectada, numeroCuenta);
        }


}

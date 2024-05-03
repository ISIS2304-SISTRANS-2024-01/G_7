package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.Cliente;
import uniandes.edu.co.parranderos.modelo.OperacionPrestamo;
import uniandes.edu.co.parranderos.modelo.Prestamo;

public interface OperacionPrestamoRepository extends JpaRepository<OperacionPrestamo, Integer>
{
    @Query(value = "SELECT * FROM operacionprestamo", nativeQuery = true)
    Collection<OperacionPrestamo> darOperacionesPrestamos();

    @Query(value = "SELECT * FROM operacionprestamo WHERE id = :id", nativeQuery = true)
    OperacionPrestamo darOperacionPrestamo(@Param("id") Cliente id);
    

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO operacionprestamo (id, numeroprestamo, idprestamo, tipoprestamo) VALUES (:id, :numeroprestamo, :idprestamo, :tipoprestamo)", nativeQuery = true)
    void registrarOperacion(@Param("id") String id, @Param("numeroprestamo") String numeroprestamo, @Param("idprestamo") String idprestamo, @Param("tipoprestamo") String tipoprestamo);

    // @Modifying
    // @Transactional
    // @Query(value = "UPDATE operacionprestamo SET id = :id, numeroprestamo = :numeroprestamo, idprestamo = :idprestamo, tipoprestamo = :tipoprestamo WHERE id = :id", nativeQuery = true)
    // void actualizarPrestamo(@Param("id") String id, @Param("numeroprestamo") String numeroprestamo, @Param("idprestamo") String idprestamo, @Param("tipoprestamo") Double tipoprestamo);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE operacionprestamo SET id = :id, numeroprestamo = :numeroprestamo, idprestamo = :idprestamo, tipoprestamo = :tipoprestamo WHERE id = :idParam", nativeQuery = true)
    void actualizarPrestamo(@Param("id") Cliente id, @Param("numeroprestamo") String numeroprestamo, @Param("idprestamo") Prestamo prestamo, @Param("tipoprestamo") Prestamo prestamo2, @Param("idParam") Integer integer);

    @Modifying
    @Transactional
    @Query(value = "UPDATE operacionprestamo SET monto = monto - :montoNuevo WHERE numeroprestamo = :numeroprestamo", nativeQuery = true)
    void actualizarPrestamoPagarCuota(@Param("numeroprestamo") String numeroprestamo, @Param("montoNuevo") String montoNuevo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE prestamo SET estado = 'Pagado' WHERE numeroprestamo = :numeroprestamo", nativeQuery = true)
    void actualizarEstadoPrestamoACerrado(@Param("numeroprestamo") String numeroprestamo);
 

}

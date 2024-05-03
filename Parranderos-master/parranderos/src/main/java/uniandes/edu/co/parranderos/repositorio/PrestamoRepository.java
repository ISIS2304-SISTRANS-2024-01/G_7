package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer>
{
    @Query(value = "SELECT * FROM prestamo", nativeQuery = true)
    Collection<Prestamo> darPrestamos();
    
    @Query(value = "SELECT * FROM prestamo WHERE idprestamo = :idprestamo", nativeQuery = true)
    Prestamo darPrestamo(@Param("idprestamo") String idprestamo);


    @Modifying
    @Transactional
    @Query(value =  "INSERT INTO prestamo (idprestamo, tipoprestamo, estado, monto, intereses, numcuotas, mespago, valorcuota) VALUES(:idprestamo, :tipoprestamo, :estado, :monto, :intereses, :numcuotas, :mespago, :valorcuota)", nativeQuery = true)
    void insertarPrestamo(@Param("idprestamo") String idprestamo, @Param("tipoprestamo") String tipoprestamo, @Param("estado") String estado, @Param("monto") Double monto, @Param("intereses") Double intereses, @Param("numcuotas") Integer numcuotas, @Param("mespago") String mespago, @Param("valorcuota") Double valorcuota);

    // @Modifying
    // @Transactional
    // @Query(value = "UPDATE prestamo SET tipoPrestamo = :tipoPrestamo, estado = :estado, monto = :monto, interes = :interes, numCuotas = :numCuotas, mesPago = :mesPago, valorCuota = :valorCuota WHERE idPrestamo = :idPrestamo", nativeQuery = true)
    // void actualizarPrestamo(@Param("idPrestamo") String idPrestamo, @Param("tipoPrestamo") String tipoPrestamo, @Param("estado") String estado, @Param("monto") Double monto, @Param("interes") Double interes, @Param("numCuotas") Integer numCuotas, @Param("mesPago") Date mesPago, @Param("valorCuota") Double valorCuota);
    
    
} 
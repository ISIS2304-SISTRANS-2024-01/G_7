package uniandes.edu.co.parranderos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{

    @Modifying
    @Transactional
    @Query(value="INSERT INTO EMPLEADO (ROL, IDEMPLEADO, DOCUMENTOIDENTIFICACIONNUMERO, DIRECCION) VALUES (:rol, :idEmpleado, :documentoIdentificacionNumero, :direccion)", nativeQuery = true)
    void insertarEmpleado(@Param("rol") String rol, @Param("idEmpleado") String idEmpleado, @Param("documentoIdentificacionNumero") int documentoIdentificacionNumero, @Param("direccion") String direccion);

}


package uniandes.edu.co.parranderos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.Oficina;

public interface OficinaRepository extends JpaRepository<Oficina, Integer>{
    
    @Modifying
    @Transactional
    @Query(value="INSERT INTO OFICINA (NOMBRE, DIRECCION, NUMPUESTOSATENCION) VALUES (:NOMBRE, :DIRECCION, :NUMPUESTOSATENCION)", nativeQuery = true)
    void insertarOficina(@Param("NOMBRE") String NOMBRE, @Param("DIRECCION") String DIRECCION, @Param("NUMPUESTOSATENCION") int NUMPUESTOSATENCION);

}


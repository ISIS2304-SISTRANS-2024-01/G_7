package uniandes.edu.co.parranderos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.PuntosAtencion;

public interface PuntosAtencionRepository extends JpaRepository<PuntosAtencion, Integer>{
    
    @Modifying
    @Transactional
    @Query(value="INSERT INTO PUNTOSATENCION (TIPO, LOCALIZACION, ID) VALUES (:TIPO, :LOCALIZACION, SECUENCIA.nextval)", nativeQuery = true) //TO-DO: falta anadir el atributo que puede ser nulo
    void insertarPuntoAtencion(@Param("TIPO") String TIPO, @Param("LOCALIZACION") String LOCALIZACION);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM PUNTOSATENCION WHERE ID=:ID", nativeQuery = true)
    void eliminarPuntoAtencion(@Param("ID") int ID);

}


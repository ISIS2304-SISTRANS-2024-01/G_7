package uniandes.edu.co.parranderos.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
    @Query(value="SELECT * FROM usuario", nativeQuery = true)
    Collection<Usuario> darUsuarios();

    @Query(value="SELECT * FROM USUARIO WHERE DOCUMENTOIDENTIFICACIONNUMERO=:documentoIdentificacionNumero", nativeQuery = true)
    Usuario darUsuario(@Param("documentoIdentificacionNumero") int documentoIdentificacionNumero);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO USUARIO (LOGIN, PALABRACLAVE, ROL, DOCUMENTOIDENTIFICACIONTIPO, DOCUMENTOIDENTIFICACIONNUMERO, NOMBRE, NACIONALIDAD, DIRECCIONFISICA, DIRECCIONELECTRONICA, TELEFONO, CIUDAD, DEPARTAMENTO, CODIGOPOSTAL) VALUES (:login, :palabraClave, :rol, :documentoIdentificacionTipo, :documentoIdentificacionNumero, :nombre, :nacionalidad, :direccionFisica, :direccionElectronica, :telefono, :ciudad, :departamento, :codigoPostal)", nativeQuery = true)
    void insertarUsuario(@Param("login") String login, @Param("palabraClave") String palabraClave, @Param("rol") String rol, @Param("documentoIdentificacionTipo") String documentoIdentificacionTipo, @Param("documentoIdentificacionNumero") int documentoIdentificacionNumero, @Param("nombre") String nombre, @Param("nacionalidad") String nacionalidad, @Param("direccionFisica") String direccionFisica, @Param("direccionElectronica") String direccionElectronica, @Param("telefono") int telefono, @Param("ciudad") String ciudad, @Param("departamento") String departamento, @Param("codigoPostal") int codigoPostal);

}


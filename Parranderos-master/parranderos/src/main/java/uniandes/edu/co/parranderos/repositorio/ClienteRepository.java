package uniandes.edu.co.parranderos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.parranderos.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

    @Query(value="SELECT * FROM CLIENTE WHERE ID=:clienteId", nativeQuery = true)
    Cliente darCliente(@Param("clienteId") int clienteId);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO CLIENTE (ID, TIPOCLIENTE) VALUES (:id, :tipoCliente)", nativeQuery = true)
    void insertarCliente(@Param("id") int id, @Param("tipoCliente") String tipoCliente);

}

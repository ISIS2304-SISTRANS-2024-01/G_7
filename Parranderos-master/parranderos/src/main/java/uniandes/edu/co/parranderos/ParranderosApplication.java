package uniandes.edu.co.parranderos;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.parranderos.modelo.OperacionPrestamo;
import uniandes.edu.co.parranderos.modelo.Prestamo;
import uniandes.edu.co.parranderos.repositorio.OperacionPrestamoRepository;
import uniandes.edu.co.parranderos.repositorio.PrestamoRepository;

@SpringBootApplication
public class ParranderosApplication{ // implements CommandLineRunner{

	// @Autowired
	// private OperacionPrestamoRepository operacionPrestamoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ParranderosApplication.class, args);
	}

	// @Override
	// public void run(String... arg) //throws Exception 
	// {
	// 	Collection<OperacionPrestamo> operacionesprestamos = operacionPrestamoRepository.darOperacionesPrestamos();
		
	// 	System.out.println("EMPIEZA A IMPRIMIR OPERACIONESPRESTAMOS -------------------");
	// 	for (OperacionPrestamo prestamo : operacionesprestamos) 
	// 	{
	// 		System.out.println(prestamo);
	// 	}
	// }
}

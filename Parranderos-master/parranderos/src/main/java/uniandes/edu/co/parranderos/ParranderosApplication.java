package uniandes.edu.co.parranderos;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.parranderos.modelo.Usuario;
import uniandes.edu.co.parranderos.repositorio.UsuarioRepository;

@SpringBootApplication
public class ParranderosApplication implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(ParranderosApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
		Collection<Usuario> usuarios = usuarioRepository.darUsuarios();
		System.out.println("EMPIEZA A IMPRIMIR USUARIOS -------------------");
		for (Usuario usuario : usuarios) {
			System.out.println(usuario.getCIUDAD());
		}
	}

}

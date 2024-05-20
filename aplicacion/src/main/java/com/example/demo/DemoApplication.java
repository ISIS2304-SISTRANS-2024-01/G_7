package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Perro;
import com.example.demo.repositorio.PerroRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	PerroRepository perroRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Perro perro = perroRepository.findByNombre("Toby");

		System.out.println("EMPIEZA A IMPRIMIR -------------------");
		System.out.println(perro.getNombre());
	}

}

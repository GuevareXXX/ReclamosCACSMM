package com.reclamos;

import com.reclamos.model.Reclamo;
import com.reclamos.repository.ReclamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReclamosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ReclamosApplication.class, args);
	}

	//para pruebas de insercion
	@Autowired
	private ReclamoRepository reclamoRepository;

	@Override
	public void run(String... args) throws Exception{
		//Reclamo reclamo1 = new Reclamo();
		//reclamoRepository.save(reclamo1);

	}
}

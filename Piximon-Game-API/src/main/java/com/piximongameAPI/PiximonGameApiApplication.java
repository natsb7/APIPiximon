package com.piximongameAPI;

import com.piximongameAPI.Entidades.Digimon;
import com.piximongameAPI.Repositorios.RepositorioDigimon;
import com.piximongameAPI.Servicios.Implementacion.GenerarDatos;
import com.piximongameAPI.api.IAPIServiceDigimon;
import com.piximongameAPI.api.RestClientDigimon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import retrofit2.Callback;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PiximonGameApiApplication implements CommandLineRunner {

	@Autowired
	private RepositorioDigimon repositorioDigimon;


	public static void main(String[] args) {
		SpringApplication.run(PiximonGameApiApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {
		List<Digimon> digimonsEnBaseDeDatos = repositorioDigimon.findAll();
		if (digimonsEnBaseDeDatos.isEmpty()) {
			// Si está vacía, realizar la llamada a la API
			IAPIServiceDigimon apiService = RestClientDigimon.getApiServiceInstance();
			apiService.obtenerDigimons().enqueue(new Callback<List<Digimon>>() {
				@Override
				public void onResponse(retrofit2.Call<List<Digimon>> call, retrofit2.Response<List<Digimon>> response) {
					List<Digimon> digimons = response.body();
					System.out.println("Número de Digimons obtenidos: " + digimons.size());

					// Guardar en la base de datos
					repositorioDigimon.saveAll(digimons);
				}

				@Override
				public void onFailure(retrofit2.Call<List<Digimon>> call, Throwable throwable) {
					System.out.println("Error al recuperar los digimons");
				}
			});
		} else {

			System.out.println("Número de Digimons en la base de datos: " + digimonsEnBaseDeDatos.size());

			List<Digimon> digimons = digimonsEnBaseDeDatos;
		}

	}
}

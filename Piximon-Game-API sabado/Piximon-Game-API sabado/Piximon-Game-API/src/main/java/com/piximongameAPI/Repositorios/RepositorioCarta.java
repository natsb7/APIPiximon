package com.piximongameAPI.Repositorios;

import com.piximongameAPI.Entidades.Carta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositorioCarta extends JpaRepository<Carta, Integer> {

    @Query(value = "SELECT * FROM cartas WHERE jugador IS NULL Limit :limit", nativeQuery = true)
    List<Carta> recuperar20CartasSinJugador(int limit);


}

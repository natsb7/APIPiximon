package com.piximongameAPI.Repositorios;

import com.piximongameAPI.Entidades.Carta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositorioCarta extends JpaRepository<Carta, Integer> {

    //Obtener un listado de las cartas que no tienen jugador asignado
    @Query(value = "SELECT * FROM cartas WHERE jugador IS NULL Limit :limit", nativeQuery = true)
    List<Carta> recuperar20CartasSinJugador(int limit);

    //obtener las cartas de un jugador concreto
    @Query(value = "SELECT * FROM cartas WHERE jugador = :id", nativeQuery = true)
    List<Carta> obtenerCartasJugador(int id);

    //obtener las cartas no asignadas a ningún jugador
    @Query(value = "SELECT * FROM cartas WHERE jugador IS NULL LIMIT 20", nativeQuery = true)
    List<Carta> obtenerCartasSinAsignar();

    @Query(value = "SELECT * FROM cartas WHERE cartas.jugador =:id AND cartas.alineacion IS NOT NULL ORDER BY cartas.alineacion ", nativeQuery = true)
    List<Carta> recuperarCartasAlineadasdeJugador(int id);
}

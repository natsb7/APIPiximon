package com.piximongameAPI.Repositorios;

import com.piximongameAPI.Entidades.Jugador;
import com.piximongameAPI.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositorioJugador extends JpaRepository<Jugador, Integer> {

    //Si quisiéramos tener alguna búsqueda o acción personalizada que queramos
    //realizar con la base de datos, la podríamos hacer aquí con nuestro propio código y métodos

    @Query(value = "SELECT * FROM jugadores WHERE partida_id = :id", nativeQuery = true)
    List<Jugador> findJugadoresByPartidaId(int id);

    //SABIENDO EL fk_usuario buscar qué jugador es en la tabla jugadores
    @Query(value = "SELECT * FROM jugadores WHERE nombre_jugador =:nombre", nativeQuery = true)
    Jugador comprobarSiExisteJugador(String nombre);

    @Query(value = "SELECT * FROM jugadores WHERE id =:id", nativeQuery = true)
    Jugador findById(int id);

    @Query(value = "SELECT * FROM jugadores", nativeQuery = true)
    List<Jugador> obtenerTodosLosJugadores();

}

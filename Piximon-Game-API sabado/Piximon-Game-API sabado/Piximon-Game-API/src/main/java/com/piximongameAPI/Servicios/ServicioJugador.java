package com.piximongameAPI.Servicios;

import com.piximongameAPI.Entidades.Jugador;

import java.util.List;

public interface ServicioJugador {

    //--------- Métodos de tipo CRUD personalizados (Create, Read, Update, Delete) ---------
    List<Jugador> obtenerTodos();

    Jugador obtenerPorId(int id);

    List<Jugador> crearJugadores(Jugador jugador);

    List<Jugador> findJugadoresByPartidaId(int id);


}

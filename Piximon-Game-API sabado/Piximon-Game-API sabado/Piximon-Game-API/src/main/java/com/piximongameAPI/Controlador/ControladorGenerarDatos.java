package com.piximongameAPI.Controlador;

import com.piximongameAPI.Entidades.Jugador;
import com.piximongameAPI.Entidades.Partida;
import com.piximongameAPI.Servicios.Implementacion.GenerarDatos;
import com.piximongameAPI.Servicios.Implementacion.ServicioJugadorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorGenerarDatos {

    @Autowired
    private GenerarDatos generarDatos;

    @Autowired
    private ServicioJugadorImpl servicioJugador;

    @PostMapping("/generarDatos")
    public boolean generarDatos(@RequestBody Jugador jugador){
        //generarDatos.recuperarDigimons();
        generarDatos.crearJugadores(jugador);
        generarDatos.crearCartas(servicioJugador.comprobarSiExisteJugador(jugador.getNombreJugador()).getPartida());
        generarDatos.asignarCartasAJugadores(servicioJugador.obtenerTodosLosJugadores());
        generarDatos.generarAlineaciones();
        generarDatos.alinearCartas();
        return true;
    }
}

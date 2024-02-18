package com.piximongameAPI.Controlador;

import com.piximongameAPI.Entidades.Jugador;
import com.piximongameAPI.Servicios.Implementacion.ServicioAlineacionImpl;
import com.piximongameAPI.Servicios.Implementacion.ServicioCartaImpl;
import com.piximongameAPI.Servicios.ServicioAlineacion;
import com.piximongameAPI.Servicios.ServicioJugador;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugadores")
public class ControladorJugador {
    @Autowired
    private ServicioJugador servicioJugador;

    @Autowired
    private ServicioCartaImpl servicioCarta;

    @Autowired
    private ServicioAlineacionImpl servicioAlineacion;
    @GetMapping("/getJugadores")
    public List<Jugador> listarJugadores() {
        List<Jugador> jugadores = servicioJugador.obtenerTodos();
        return jugadores;
    }

    @PostMapping("/addJugadores")
    public boolean addJugador(@RequestBody Jugador jugador) {
        System.out.println(jugador.toString());
        try {
            Jugador jugadorInsertado = jugador;
            System.out.println(jugadorInsertado.toString());
            //repositorioJugador.save(jugadorInsertado);
            servicioAlineacion.generarAlineaciones();
            servicioJugador.crearJugadores(jugador);
            //servicioCarta.alinearCartas();


            return true;
        } catch (Exception e) {
            System.out.println("addJugador ERROR:" + e.getMessage());
            return false;
        }
    }
}

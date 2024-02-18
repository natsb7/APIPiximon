package com.piximongameAPI.Controlador;

import com.piximongameAPI.Entidades.Carta;
import com.piximongameAPI.Repositorios.RepositorioCarta;
import com.piximongameAPI.Servicios.ServicioCarta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cartas")
public class ControladorCarta {

    /*@Autowired
    private RepositorioCarta repositorioCarta;*/

    @Autowired
    private ServicioCarta servicioCarta;

    @GetMapping("/getCartas")
    public List<Carta> listarCartas() {
        List<Carta> cartas = servicioCarta.obtenerCartas();
        return cartas;
    }


}

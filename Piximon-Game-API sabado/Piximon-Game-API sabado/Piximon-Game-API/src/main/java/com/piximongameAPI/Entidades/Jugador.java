package com.piximongameAPI.Entidades;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//@NoArgsConstructor
//@AllArgsConstructor
@Data
@Entity
@Table(name = "jugadores")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombreJugador;

    @Column
    private String iconoJugador;

    @Column
    private double dineroJugador;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "partida_id", referencedColumnName = "id") //partida_id es el campo de la tabla jugador que hace referencia al id de la tabla partida
    private Partida partida;

    @OneToOne(mappedBy = "jugador", cascade = CascadeType.ALL)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private Combate combate;


    /*@OneToOne(mappedBy = "jugador", cascade = CascadeType.ALL)
    private Alineacion alineacion;*/


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario", referencedColumnName = "id") //hace referencia al id de la tabla usuario
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "jugador")
    private List<Carta> cartas = new ArrayList<>();

    public Jugador() {
    }

    public Jugador(String nombreJugador, String iconoJugador, double dineroJugador) {
        this.nombreJugador = nombreJugador;
        this.iconoJugador = iconoJugador;
        this.dineroJugador = dineroJugador;
    }

    public Jugador(String nombreJugador, String iconoJugador, double dineroJugador, Partida partida, Usuario usuario) {
        this.nombreJugador = nombreJugador;
        this.iconoJugador = iconoJugador;
        this.dineroJugador = dineroJugador;
        this.partida = partida;
        this.usuario = usuario;
    }
}

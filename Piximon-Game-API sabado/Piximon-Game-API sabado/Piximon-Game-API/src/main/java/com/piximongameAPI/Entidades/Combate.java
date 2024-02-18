package com.piximongameAPI.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "combates")
public class Combate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "jugador_id")
    private Jugador jugador;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "usuario_winner")
    private int usuarioWinner;

    @Column(name = "jugador_winner")
    private int jugadorWinner;

    /*@OneToMany(mappedBy = "ronda", cascade = CascadeType.ALL)
    private List<Ronda> rondas = new ArrayList<>();*/

    @OneToMany(mappedBy = "combate")
    private List<Ronda> rondas;

}

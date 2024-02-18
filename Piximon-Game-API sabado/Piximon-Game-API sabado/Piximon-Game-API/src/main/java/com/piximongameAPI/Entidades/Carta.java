package com.piximongameAPI.Entidades;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "cartas")
public class Carta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombreCarta;

    @Column
    private String imgCarta;

    @Column
    private int valorCarta;

    @Column
    private int nivelCarta;

    @Column
    private String vidaCarta;

    @ManyToOne
    @JoinColumn(name = "jugador")
    private Jugador jugador;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "alineacion")
    private Alineacion alineacion;

    @Column
    private int posicion;

}

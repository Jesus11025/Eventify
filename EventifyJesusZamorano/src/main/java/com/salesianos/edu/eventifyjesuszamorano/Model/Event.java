package com.salesianos.edu.eventifyjesuszamorano.Model;

import com.salesianos.edu.eventifyjesuszamorano.Enum.EstadoEvento;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Evento")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idEvento", nullable = false)
    private Long id;

    private String nombre;
    private LocalDate fechaRealizacion;
    private EstadoEvento estadoEvento;
    private int cantidadEntradasVendidas;

    @ManyToOne
    private Organizer organizer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @OneToMany()
    @JoinColumn(name = "organizerId")
    private List<Ticket> ticket;
}

package com.salesianos.edu.eventifyjesuszamorano.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Organizacion")
public class Organizer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idOrganizer", nullable = false)
    private Long id;

    private String nombre;
    private LocalDate fechaCreacion;

    @OneToMany(mappedBy = "organizer")
    private Event evento;

    @ManyToOne
    private Venue venue;
}

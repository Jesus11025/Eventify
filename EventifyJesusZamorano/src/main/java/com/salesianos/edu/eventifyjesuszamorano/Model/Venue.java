package com.salesianos.edu.eventifyjesuszamorano.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Venue")
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idVenue", nullable = false)
    private Long id;

    private String nombre;
    private String localizacion;
    private int aforoMax;

    @OneToMany
    @JoinColumn(name = "venueId")
    private List<Event> event = new ArrayList<>();
}

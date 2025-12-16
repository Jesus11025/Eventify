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
@Table(name = "Attendee")
public class Attendee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAttendee", nullable = false)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "attendee")
    private List<Ticket> tickets = new ArrayList<>();

    @OneToMany(mappedBy = "attendee")
    private List<StaffAssignment> staffAssignments = new ArrayList<>();
}

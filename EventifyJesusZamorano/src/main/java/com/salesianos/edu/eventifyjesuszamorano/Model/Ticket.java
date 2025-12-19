package com.salesianos.edu.eventifyjesuszamorano.Model;

import com.salesianos.edu.eventifyjesuszamorano.Enum.TypeTicket;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idTicket", nullable = false)
    private Long id;

    private String nombreComprador;
    private Boolean isComprado;
    private LocalDate fechaCompra;
    private double precio;
    @Column(unique = true)
    private TypeTicket type;
    @Column(name = "qrCode",nullable = false, unique = true)
    private String qrCode;

    @ManyToOne
    @Column(unique = true)
    private Event event;

    @ManyToOne
    @Column(unique = true)
    private Attendee attendee;
}

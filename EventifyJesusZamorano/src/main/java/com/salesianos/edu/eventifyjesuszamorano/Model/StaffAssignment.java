package com.salesianos.edu.eventifyjesuszamorano.Model;

import com.salesianos.edu.eventifyjesuszamorano.Enum.RoleStaff;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Staff")
public class StaffAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idStaff", nullable = false)
    private Long id;

    private RoleStaff role;

    @ManyToOne
    @JoinColumn(name = "attendee_id", nullable = false)
    private Attendee attendee;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;
}

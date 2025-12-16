package com.salesianos.edu.eventifyjesuszamorano.Repository;

import com.salesianos.edu.eventifyjesuszamorano.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    boolean existsByAttendeeAndEvent(Long attendeeId, Long eventId);
}

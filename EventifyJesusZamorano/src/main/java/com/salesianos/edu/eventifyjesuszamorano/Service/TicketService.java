package com.salesianos.edu.eventifyjesuszamorano.Service;

import com.salesianos.edu.eventifyjesuszamorano.Enum.EstadoEvento;
import com.salesianos.edu.eventifyjesuszamorano.Model.Attendee;
import com.salesianos.edu.eventifyjesuszamorano.Model.Event;
import com.salesianos.edu.eventifyjesuszamorano.Model.Ticket;
import com.salesianos.edu.eventifyjesuszamorano.Repository.AttendeeRepository;
import com.salesianos.edu.eventifyjesuszamorano.Repository.EventRepository;
import com.salesianos.edu.eventifyjesuszamorano.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    private EventRepository eventRepository;
    private AttendeeRepository attendeeRepository;

    public void buyTicket(Ticket ticket, Long idAttende) {
        if (ticket == null) {
            throw new RuntimeException("El ticket no puede ser nulo");
        }
        if (ticket.getAttendee() == null) {
            throw new RuntimeException("El ticket necesita un Attendee");
        }
        if (ticket.getEvent() == null) {
            throw new RuntimeException("El ticket necesita un evento");
        }
        if (ticket.getIsComprado() == true) {
            throw new RuntimeException("El ticket ya ha sido comprado");
        }

        Event eventS = eventRepository.findById(ticket.getEvent().getId())
                .orElseThrow(() -> new RuntimeException("Evento no encontrado"));
        Attendee attendeeS = attendeeRepository.findById(idAttende)
                .orElseThrow(() -> new RuntimeException("Attendee no encontrado"));

        if (ticketRepository.existsByAttendeeAndEvent(attendeeS.getId(), eventS.getId())) {
            throw new RuntimeException("Ya hay un ticket identico a este");
        }
        if(attendeeS.getTickets().contains(eventS.getTicket())) {
            throw new RuntimeException("El attendee ya tiene una entrada para dicho evento");
        }
        if(ticket.getEvent().getEstadoEvento() != EstadoEvento.PUBLISHED) {
            if(eventS.getVenue().getAforoMax() > eventS.getCantidadEntradasVendidas()) {
                ticket.setAttendee(attendeeS);
                ticket.setEvent(eventS);

                ticketRepository.save(ticket);
            } else {
                throw new RuntimeException("El afoto ya está completo");
            }
        } else {
            throw new RuntimeException("El estado del evento esta cancelado o ya ha acabado");
        }


        ticket.setAttendee(attendeeS);
        ticket.setEvent(eventS);

        ticketRepository.save(ticket);

    }

    public List<Ticket> listaTicketsEvento(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("El id del evento no corresponde a ningún evento"));

        if(event.getTicket() != null) {
            return event.getTicket();
        } else {
            throw new RuntimeException("La lista de tickets del evento está vacia");
        }
    }




}

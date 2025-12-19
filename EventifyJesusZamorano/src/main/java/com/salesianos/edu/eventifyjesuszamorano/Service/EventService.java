package com.salesianos.edu.eventifyjesuszamorano.Service;

import com.salesianos.edu.eventifyjesuszamorano.Enum.EstadoEvento;
import com.salesianos.edu.eventifyjesuszamorano.Model.Event;
import com.salesianos.edu.eventifyjesuszamorano.Model.Organizer;
import com.salesianos.edu.eventifyjesuszamorano.Model.Venue;
import com.salesianos.edu.eventifyjesuszamorano.Repository.EventRepository;
import com.salesianos.edu.eventifyjesuszamorano.Repository.OrganizerRepository;
import com.salesianos.edu.eventifyjesuszamorano.Repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;
    private VenueRepository venueRepository;
    private OrganizerRepository organizerRepository;


    public void eventCreate(Event evento) {

        if(evento == null) {
            throw new RuntimeException("Evento es nulo");
        }
        if(evento.getFechaRealizacion() == null) {
            throw new RuntimeException("Evento no creado");
        }

        Venue venue = venueRepository.findById(evento.getVenue().getId())
                .orElseThrow(() -> new RuntimeException("Venue no encontrado"));
        Organizer organizer = organizerRepository.findById(evento.getOrganizer().getId())
                .orElseThrow(() -> new RuntimeException("Organizer no encontrado"));
        if(evento.getOrganizer() == null || evento.getVenue() == null) {
            throw new RuntimeException("Organizer o Venue están vacias");
        }
        if(evento.getFechaRealizacion().isBefore(LocalDate.now())) {
            throw new RuntimeException("La fecha del evento no puedo es valida, ya que es anterior al día de hoy");
        }
        if (evento.getEstadoEvento() == EstadoEvento.CANCELED) {
            throw new RuntimeException("El evento no puede estar cancelado");
        }
        evento.setVenue(venue);
        evento.setOrganizer(organizer);

        eventRepository.save(evento);
    }

    public void cancelEvent(Long eventID) {
        if(eventID == null) {
            throw  new RuntimeException("La id del evento es nula");
        }
        Event evento = eventRepository.findById(eventID)
                .orElseThrow(() -> new RuntimeException("No se ha encontrado el evento"));
        if(evento.getEstadoEvento()  == EstadoEvento.CANCELED) {
            throw new RuntimeException("El evento ya estaba cancelado");
        }
        evento.setEstadoEvento(EstadoEvento.CANCELED);
    }

}

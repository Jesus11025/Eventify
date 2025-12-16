package com.salesianos.edu.eventifyjesuszamorano.Service;

import com.salesianos.edu.eventifyjesuszamorano.Model.Event;
import com.salesianos.edu.eventifyjesuszamorano.Model.Organizer;
import com.salesianos.edu.eventifyjesuszamorano.Model.Venue;
import com.salesianos.edu.eventifyjesuszamorano.Repository.EventRepository;
import com.salesianos.edu.eventifyjesuszamorano.Repository.OrganizerRepository;
import com.salesianos.edu.eventifyjesuszamorano.Repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;
    private VenueRepository venueRepository;
    private OrganizerRepository organizerRepository;


    public void createEvent(Event evento) {

        if(evento == null) {
            throw new RuntimeException("Evento es nulo");
        }
        if(evento.getFechaCreacion() == null) {
            throw new RuntimeException("Evento no creado");
        }

        Venue venue = venueRepository.findById(evento.getVenue().getId())
                .orElseThrow(() -> new RuntimeException("Venue no encontrado"));
        Organizer organizer = organizerRepository.findById(evento.getOrganizer().getId())
                .orElseThrow(() -> new RuntimeException("Organizer no encontrado"));

        evento.setVenue(venue);
        evento.setOrganizer(organizer);

        eventRepository.save(evento);
    }

//    public void asignarStaff(Long eventId, Long staffId, ) {
//
//    }
}

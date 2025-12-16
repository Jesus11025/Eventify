package com.salesianos.edu.eventifyjesuszamorano.Service;

import com.salesianos.edu.eventifyjesuszamorano.Repository.EventRepository;
import com.salesianos.edu.eventifyjesuszamorano.Repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenueService {

    @Autowired
    private VenueRepository venueRepository;
    private EventRepository eventRepository;

    
}

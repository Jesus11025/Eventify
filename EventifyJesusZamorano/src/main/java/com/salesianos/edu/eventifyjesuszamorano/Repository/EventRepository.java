package com.salesianos.edu.eventifyjesuszamorano.Repository;

import com.salesianos.edu.eventifyjesuszamorano.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

//    buscarCiudad(String nombreCiudad);
}

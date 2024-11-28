package de.stefanzindl.de.specialdaysapi.rest;

import de.stefanzindl.de.specialdaysapi.entities.Event;
import de.stefanzindl.de.specialdaysapi.entities.EventDTO;
import de.stefanzindl.de.specialdaysapi.services.SpecialDaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventsRestController {

    private final SpecialDaysService specialDaysService;

    @Autowired
    public EventsRestController(SpecialDaysService specialDaysService) {
        this.specialDaysService = specialDaysService;
    }

    @PutMapping("/api/events")
    public boolean addEvent(@RequestBody EventDTO event) {
        return specialDaysService.addEvent(event) != null;
    }
    @GetMapping("/api/events")
    public List<Event> getEvents() {
        return specialDaysService.getAll();
    }    @GetMapping("/api/events/today")
    public List<Event> getEventsToday(@RequestParam String countryCode) {
        return specialDaysService.getAllByCountryCode(countryCode);
    }
}
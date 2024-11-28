package de.stefanzindl.de.specialdaysapi.services;

import de.stefanzindl.de.specialdaysapi.entities.Event;
import de.stefanzindl.de.specialdaysapi.entities.EventDTO;
import de.stefanzindl.de.specialdaysapi.repositories.CountryRepository;
import de.stefanzindl.de.specialdaysapi.repositories.EventNameRepository;
import de.stefanzindl.de.specialdaysapi.repositories.SpecialDaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class SpecialDaysService {

    private final SpecialDaysRepository eventRepository;
    private final EventNameRepository eventNameRepository;
    private final CountryRepository countryRepository;

    @Autowired
    public SpecialDaysService(SpecialDaysRepository eventRepository, EventNameRepository eventNameRepository, CountryRepository countryRepository) {
        this.eventRepository = eventRepository;
        this.eventNameRepository = eventNameRepository;
        this.countryRepository = countryRepository;
    }

    public Event addEvent(EventDTO specialDay) {
        Event event = Event.builder().eventName(specialDay.getEventName())
                .startDay(specialDay.getStartMonth())
                .startMonth(specialDay.getStartMonth())
                .endMonth(specialDay.getEndMonth())
                .isInternational(specialDay.isInternational())
                .endDay(specialDay.getEndMonth()).build();
        return eventRepository.save(event);
    }

    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    public List<Event> getAllToday() {
        return new ArrayList<Event>(eventRepository.findAll());
        //    return eventRepository.findAllByDate(LocalDate.now());
    }

    public List<Event> findAllByDate(LocalDate date) {
        return new ArrayList<Event>(eventRepository.findAll());
        //  return eventRepository.findAllByDate(date);
    }

    public List<Event> getAllByCountryCode(String countryCode) {
        // Country country = countryRepository.findByCountryCode(countryCode);
        // return eventRepository.findAllByCountry_id(country.getId());
        return new ArrayList<Event>(eventRepository.findAll());
    }
}

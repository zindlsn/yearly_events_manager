package de.stefanzindl.de.specialdaysapi.repositories;

import de.stefanzindl.de.specialdaysapi.entities.Country;
import de.stefanzindl.de.specialdaysapi.entities.Event;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SpecialDaysRepository extends ListCrudRepository<Event,Long> {

    List<Event> findAll();
    List<Event> findAllByCountryId(Long id);
}
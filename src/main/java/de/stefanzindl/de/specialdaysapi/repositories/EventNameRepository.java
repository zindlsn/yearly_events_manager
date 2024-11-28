package de.stefanzindl.de.specialdaysapi.repositories;

import de.stefanzindl.de.specialdaysapi.entities.Event;
import de.stefanzindl.de.specialdaysapi.entities.EventName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventNameRepository extends CrudRepository<EventName,Long> {

    List<EventName> findAll();

}
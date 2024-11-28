package de.stefanzindl.de.specialdaysapi.entities;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.Set;

@Builder
public class CountryEvents {
    private Long id;
    private String name;

    @OneToMany(mappedBy = "country")
    private Set<Event> events;
}

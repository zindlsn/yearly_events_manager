package de.stefanzindl.de.specialdaysapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@Builder
@AllArgsConstructor
@Table(name = "event_names")
public class EventName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String eventName;

    private Long LanguageID;

    private Long CountryID;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country Country;


    public EventName() {

    }
}

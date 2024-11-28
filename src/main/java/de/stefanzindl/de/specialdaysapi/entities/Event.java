package de.stefanzindl.de.specialdaysapi.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity
@Builder
@AllArgsConstructor
@Table(name = "events")
@Getter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

    private int startDay;
    private int startMonth;
    private int endDay;
    private int endMonth;

    private Long translation_id;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_names_id")
    private EventName eventName;
    private boolean isInternational;

    public Event() {

    }
}




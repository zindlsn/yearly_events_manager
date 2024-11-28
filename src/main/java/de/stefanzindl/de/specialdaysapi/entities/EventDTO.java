package de.stefanzindl.de.specialdaysapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
public class EventDTO {
    private String title;
    private int startMonth;
    private int startDay;
    private int endMonth;
    private boolean isInternational;
    List<String> happeningCountryCodes;
    EventName eventName;
}

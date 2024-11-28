package de.stefanzindl.de.specialdaysapi.rest;

import de.stefanzindl.de.specialdaysapi.entities.Country;
import de.stefanzindl.de.specialdaysapi.entities.Event;
import de.stefanzindl.de.specialdaysapi.entities.EventDTO;
import de.stefanzindl.de.specialdaysapi.services.CountryService;
import de.stefanzindl.de.specialdaysapi.services.SpecialDaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CountryRestController {

    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PutMapping("/api/countries")
    public void addCountry(@RequestBody Country country) {
        countryService.add(country);
    }

    @PutMapping("/api/countries")
    public void addCountries(@RequestBody List<Country> country) {
        countryService.addAll(country);
    }
}
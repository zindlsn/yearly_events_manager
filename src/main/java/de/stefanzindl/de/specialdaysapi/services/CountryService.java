package de.stefanzindl.de.specialdaysapi.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.stefanzindl.de.specialdaysapi.entities.Country;
import de.stefanzindl.de.specialdaysapi.entities.Event;
import de.stefanzindl.de.specialdaysapi.entities.EventDTO;
import de.stefanzindl.de.specialdaysapi.entities.EventName;
import de.stefanzindl.de.specialdaysapi.repositories.CountryRepository;
import de.stefanzindl.de.specialdaysapi.repositories.EventNameRepository;
import de.stefanzindl.de.specialdaysapi.repositories.SpecialDaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public void add(Country country) {
        countryRepository.save(country);
    }

    public void addAll(List<Country> countries) {
        countryRepository.saveAll(countries);
    }

    public List<Country> fetchCountriesFromUrl(String url) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String jsonString = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonString, new TypeReference<List<Country>>(){});
    }
}

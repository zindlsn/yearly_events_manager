package de.stefanzindl.de.specialdaysapi;

import de.stefanzindl.de.specialdaysapi.entities.Country;
import de.stefanzindl.de.specialdaysapi.entities.Event;
import de.stefanzindl.de.specialdaysapi.entities.EventDTO;
import de.stefanzindl.de.specialdaysapi.entities.EventName;
import de.stefanzindl.de.specialdaysapi.repositories.EventNameRepository;
import de.stefanzindl.de.specialdaysapi.services.CountryService;
import de.stefanzindl.de.specialdaysapi.services.SpecialDaysService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpecialDaysApiApplication {

    public static void main(String[] args) {
		SpringApplication.run(SpecialDaysApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(SpecialDaysService specialDaysService, EventNameRepository eventNameRepository, CountryService countryService) {
		return _ -> {
			initCountries(countryService);
			EventName newYear = EventName.builder().eventName("New Year").CountryID(1L).build();
			eventNameRepository.save(newYear);
			EventDTO eventDTO = EventDTO.builder().startMonth(1).startDay(1).eventName(newYear).isInternational(true).build();
			specialDaysService.addEvent(eventDTO);
		};
	}

	private void initCountries(CountryService countryService) throws Exception {
		var x =     		countryService.fetchCountriesFromUrl("https://gist.githubusercontent.com/anubhavshrimal/75f6183458db8c453306f93521e93d37/raw/f77e7598a8503f1f70528ae1cbf9f66755698a16/CountryCodes.json");
		System.out.println(x);
		countryService.addAll(x);
	}


}

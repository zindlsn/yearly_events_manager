package de.stefanzindl.de.specialdaysapi.repositories;

import de.stefanzindl.de.specialdaysapi.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByCode(String countryCode);
}

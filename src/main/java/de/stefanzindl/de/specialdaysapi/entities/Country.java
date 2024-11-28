package de.stefanzindl.de.specialdaysapi.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Entity
@AllArgsConstructor
@Table(name = "countries")
@Getter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonProperty("dial_code")
    private String DialCode;

    private String code;

    public Country() {

    }
}

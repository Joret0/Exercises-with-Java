package app.service;

import app.domain.dto.PersonDto;
import app.domain.model.Person;

import java.util.List;

public interface PersonService {

    void create(PersonDto dto);

    PersonDto findById(long id);

    List<Person> findByCountry(String country);
}

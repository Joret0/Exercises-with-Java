package app.serviceImpl;

import app.domain.dto.AddressDto;
import app.domain.dto.PersonDto;
import app.domain.dto.PhoneNumberDto;
import app.domain.model.Address;
import app.domain.model.Person;
import app.domain.model.PhoneNumber;
import app.repository.PersonRepository;
import app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;


    @Override
    public void create(PersonDto dto) {
        Person person = this.mapDtoToModel(dto);
        this.personRepository.saveAndFlush(person);
    }

    @Override
    public PersonDto findById(long id) {
        Person person = this.personRepository.findOne(id);
        return this.mapModelToDto(person);
    }

    private PersonDto mapModelToDto(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());
        AddressDto addressDto = new AddressDto();
        addressDto.setCountry(person.getAddress().getCountry());
        addressDto.setCity(person.getAddress().getCity());
        addressDto.setStreet(person.getAddress().getStreet());
        personDto.setAddress(addressDto);
        for (PhoneNumber phoneNumber : person.getPhoneNumbers()) {
            PhoneNumberDto phoneNumberDto = new PhoneNumberDto();
            phoneNumberDto.setNumber(phoneNumber.getNumber());
            personDto.getPhoneNumbers().add(phoneNumberDto);
        }
        return personDto;
    }

    private Person mapDtoToModel(PersonDto dto) {
        Person person = new Person();
        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        Address address = new Address();
        address.setCountry(dto.getAddress().getCountry());
        address.setCity(dto.getAddress().getCity());
        address.setStreet(dto.getAddress().getStreet());
        person.setAddress(address);
        for (PhoneNumberDto phoneNumberDto : dto.getPhoneNumbers()) {
            PhoneNumber phoneNumber = new PhoneNumber();
            phoneNumber.setNumber(phoneNumberDto.getNumber());
            phoneNumber.setPerson(person);
            person.getPhoneNumbers().add(phoneNumber);
        }
        return person;
    }

    @Override
    public List<Person> findByCountry(String country) {
        return this.personRepository.findByCountry(country);
    }
}

package com.crossasyst.personregistration.service;

import com.crossasyst.personregistration.entity.PersonEntity;
import com.crossasyst.personregistration.mapper.PersonMapper;
import com.crossasyst.personregistration.model.Person;
import com.crossasyst.personregistration.repository.PersonRepository;
import com.crossasyst.personregistration.response.PersonResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class PersonServcie {

    public final PersonMapper personMapper;

    public final PersonRepository personRepository;

    @Autowired
    public PersonServcie(PersonMapper personMapper, PersonRepository personRepository) {
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }

    public PersonResponse CreatePerson(Person person) {

        log.info("Adding person details");
        PersonEntity personEntity = personMapper.modelToEntity(person);
        personRepository.save(personEntity);
        log.info("Person details saved successfully.");

        PersonResponse personResponse = new PersonResponse();
        personResponse.setId(personEntity.getPersonId());
        log.info("Your person id is {}", personResponse.getId());
        return personResponse;
    }


    //    public List<Person> getAllPersons() {
//        List<PersonEntity> personEntities =personRepository.findAll();
//        List<Person> personList =personMapper.entityToModels(personEntities);
//        return personList;
//    }
    public List<Person> getAllPersons() {
        List<Person> personList = personMapper.entityToModels((List<PersonEntity>) personRepository.findAll());
        log.info("get All Person");
        return personList;
    }

    public Person getPersonById(Long personId) {
        PersonEntity personEntity = personRepository.findById(personId).get();
        Person person = personMapper.entityToModel(personEntity);
        log.info("get person By Id");
        return person;
    }

    public void updatePerson(Long personId, Person person) {
        PersonEntity personEntity = personRepository.findById(personId).get();
        Person person1 = personMapper.entityToModel(personEntity);
        person1.setPerson_image(person.getPerson_image());
        log.info("update person:" + personId);
    }

    public void deletePersonById(Long personId) {
        Optional<PersonEntity> personEntity = personRepository.findById(personId);
        if (personEntity.isPresent()) {
            personRepository.deleteById(personId);
        } else {
            log.info("personId" + personId + "is not present in your dataBase");
        }
    }
}

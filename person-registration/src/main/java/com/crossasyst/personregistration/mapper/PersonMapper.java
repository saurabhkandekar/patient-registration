package com.crossasyst.personregistration.mapper;

import com.crossasyst.personregistration.entity.PersonEntity;
import com.crossasyst.personregistration.model.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonEntity modelToEntity(Person person);

    Person entityToModel (PersonEntity personEntity);

    List<Person> entityToModels (List<PersonEntity> personEntity);
}

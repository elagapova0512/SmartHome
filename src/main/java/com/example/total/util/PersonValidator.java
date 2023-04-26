package com.example.total.util;

import com.example.total.models.Person;
import com.example.total.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    private final PersonService personService;

    public PersonValidator(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
 Person person = (Person) target;
 if(personService.findByLogin(person) !=null){
     errors.rejectValue("login","","Данный логин уже занят");
 }
    }
}
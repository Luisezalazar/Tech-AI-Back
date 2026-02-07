package com.example.demo.service;

import java.time.LocalDate;

import java.util.List;

import com.example.demo.model.Person;



public interface IPersonService {

    public List<Person>getAllPersons();

    public Person getPersonById(Integer id);

    public void savePerson(Person person);

    public void deletePerson(Integer id);

    public void editPerson(Integer originalId, String newName, String newLastName, String newDni, String newArea, String newPhone, LocalDate newBirthDate, LocalDate newEntryDate);
    

}

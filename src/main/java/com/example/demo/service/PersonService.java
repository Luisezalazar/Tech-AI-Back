package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.repository.IPersonRepository;



@Service
public class PersonService implements IPersonService{

    @Autowired
    IPersonRepository personRepo;

    @Override
    public List<Person> getAllPersons() {
        List<Person> listPerson = personRepo.findAll();
        return listPerson;
    }

    @Override
    public Person getPersonById(Integer id) {
        return personRepo.findById(id).orElse(null);
    }

    @Override
    public void savePerson(Person person) {
        personRepo.save(person);
    }

    @Override
    public void deletePerson(Integer id) {
        personRepo.deleteById(id);
    }

    @Override
    public void editPerson(Integer originalId, String newName, String newLastName, String newDni, String newArea, String newPhone, LocalDate newBirthDate, LocalDate newEntryDate) {
        
        Person per = this.getPersonById(originalId);
        per.setName(newName);
        per.setLastName(newLastName);
        per.setDni(newDni);
        per.setArea(newArea);
        per.setPhone(newPhone);
        per.setBirthDate(newBirthDate);
        per.setEntryDate(newEntryDate);
        this.savePerson(per);
    }
    
}

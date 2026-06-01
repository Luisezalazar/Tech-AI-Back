package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.IPersonService;



@RestController
@RequestMapping("/person")
public class PersonController {
    
    @Autowired
    private IPersonService personService;

    @GetMapping("/getAllPerson")
    public List<Person>getAllPersons(){
        List<Person> listPerson= personService.getAllPersons();
        return listPerson;
    }

    @GetMapping("/getPersonById/{id}")
    public Person getPersonById(@PathVariable Integer id){
        Person per= personService.getPersonById(id);
        return per;
    }

    @PostMapping("/savePerson")
    public void savePerson(@RequestBody Person person){
        personService.savePerson(person);
    }

    @DeleteMapping("/deletePerson/{id}")
    public void deletePerson(@PathVariable Integer id){
        personService.deletePerson(id);
    }

    @PutMapping("/editPerson/{originalId}")
    public Person editPerson(@PathVariable Integer originalId,@RequestParam(required=false, name="name")String newName,
    @RequestParam (required=false, name="lastName")String newLastName,
    @RequestParam (required=false, name="dni")String newDni,
    @RequestParam (required=false, name="area")String newArea,
    @RequestParam (required=false, name="phone")String newPhone,
    @RequestParam (required=false, name="birthDate")LocalDate newBirthDate,
    @RequestParam (required=false, name="entryDate")LocalDate newEntryDate){
        personService.editPerson(originalId, newName, newLastName, newDni, newArea, newPhone, newBirthDate, newEntryDate);
        Person per= personService.getPersonById(originalId);
        return per;
    }
}

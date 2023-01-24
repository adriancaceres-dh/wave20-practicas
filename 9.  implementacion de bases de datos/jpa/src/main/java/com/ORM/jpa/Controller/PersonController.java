package com.ORM.jpa.Controller;

import com.ORM.jpa.Models.Person;
import com.ORM.jpa.Service.IPersonService;
import com.ORM.jpa.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    IPersonService personService;

    @PostMapping()
    public Person postPersona(@RequestBody Person person){
        return personService.createPerson(person);
    }

    @GetMapping("/id/{id}")
    public Person getPersona(@PathVariable int id){
        return personService.getById(id);
    }

    @GetMapping("/all")
    public List<Person> getAll(){
        return personService.getAll();
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable Integer id){
        personService.delete(id);
    }
}

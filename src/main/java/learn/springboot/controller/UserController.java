package learn.springboot.controller;

import learn.springboot.annotation.Limit;
import learn.springboot.entity.Person;
import learn.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "spring")
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping(value = "add")
    public ResponseEntity<Boolean> addUser(Person person)
    {
        return new ResponseEntity<>(userService.addPerson(person), HttpStatus.OK);
    }

    @GetMapping(value = "query/{id}")
    public ResponseEntity<Person> getUser(@PathVariable(value = "id")Long id)
    {
        return new ResponseEntity<>(userService.getPerson(id),HttpStatus.OK);
    }

    @Limit
    @GetMapping(value = "playGame/{id}")
    public ResponseEntity<Person> palyLol(@PathVariable(value = "id")Long id)
    {
        return new ResponseEntity<>(userService.palyLol(id),HttpStatus.OK);
    }
}

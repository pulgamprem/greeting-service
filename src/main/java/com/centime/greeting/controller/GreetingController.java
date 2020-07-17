package com.centime.greeting.controller;

import com.centime.greeting.model.Person;
import com.centime.greeting.service.GreetingService;
import com.centime.greeting.util.LogMethodParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controller for greeting the person.
 * @author Prem
 */
@RestController
@RequestMapping("/health")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @LogMethodParam
    @GetMapping
    public ResponseEntity<String> health() {
        return ResponseEntity.ok().body("UP");
    }

    @LogMethodParam
    @PostMapping(path = "/greeting", consumes = "application/json")
    public ResponseEntity<String> greetPerson(@RequestBody Person person) {
        return ResponseEntity.of(Optional.of(greetingService.greetPerson(person)));
    }
}

package com.centime.greeting.service.impl;

import com.centime.greeting.integration.concat.ConcatService;
import com.centime.greeting.integration.hello.HelloService;
import com.centime.greeting.model.Person;
import com.centime.greeting.service.GreetingService;
import com.centime.greeting.util.LogMethodParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service to greet the person.
 * @author  Prem
 */
@Service
public class GreetingServiceImpl implements GreetingService {

    @Autowired
    private HelloService helloService;

    @Autowired
    private ConcatService concatService;

    @Override
    @LogMethodParam
    public String greetPerson(Person person) {
        if(person == null || person.getName() == null || person.getSurName() == null) {
            throw new IllegalArgumentException("Name/Surname cannot be null");
        }
        String hello = helloService.getHello();
        String concatedName = concatService.concat(person);
        return hello + " " + concatedName;
    }
}
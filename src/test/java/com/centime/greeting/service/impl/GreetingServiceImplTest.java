package com.centime.greeting.service.impl;

import com.centime.greeting.dto.PersonDTO;
import com.centime.greeting.integration.concat.ConcatService;
import com.centime.greeting.integration.hello.HelloService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class GreetingServiceImplTest {

    public static final String SUR_NAME = "Doe";
    public static final String NAME = "John";
    public static final String HELLO_RESPONSE = "Hello";
    public static final String CONCAT_RESPONSE = "John Doe";
    public static final String GREET_RESPONSE = "Hello John Doe";

    @InjectMocks
    private GreetingServiceImpl greetingService;

    @Mock
    private HelloService helloService;

    @Mock
    private ConcatService concatService;
    
    private PersonDTO person;
            
    @Before
    public void setUp() {
        person = buildPersonDTO();
        doReturn(HELLO_RESPONSE).when(helloService).getHello();
        doReturn(CONCAT_RESPONSE).when(concatService).concat(person);
    }

    @Test
    public void greetPerson() {
        String greetResponse = greetingService.greetPerson(person);
        assertThat(greetResponse).isNotEmpty();
        assertThat(greetResponse).isEqualTo(GREET_RESPONSE);
    }

    public PersonDTO buildPersonDTO() {
        PersonDTO personDTO = PersonDTO.builder()
                .name(NAME)
                .surName(SUR_NAME)
                .build();
        return personDTO;
    }
}
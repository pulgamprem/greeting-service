package com.centime.greeting.integration.concat;

import com.centime.greeting.model.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "concat", url = "${integration.concat.url}")
public interface ConcatClient {

    @PostMapping
    String concat(@RequestHeader("correlationId") String correlationId, Person person);
}

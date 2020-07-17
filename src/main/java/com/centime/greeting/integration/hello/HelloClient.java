package com.centime.greeting.integration.hello;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "hello", url = "${integration.hello.url}")
public interface HelloClient {

    @GetMapping
    String hello(@RequestHeader("correlationId") String correlationId);
}
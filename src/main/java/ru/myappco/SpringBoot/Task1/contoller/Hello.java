package ru.myappco.SpringBoot.Task1.contoller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @Value("${hello.param.port:not found}")
    private String param;

    @GetMapping("/")
    private String hello() {
        return String.format("Hello. I'm version 2 service. I work on port %s", param);
    }
}

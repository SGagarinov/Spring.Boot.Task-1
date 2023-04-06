package ru.myappco.SpringBoot.Task1.contoller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.myappco.SpringBoot.Task1.entity.User;
import ru.myappco.SpringBoot.Task1.enums.Authorities;
import ru.myappco.SpringBoot.Task1.service.AuthorizationService;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class AuthorizationController {

    @Autowired
    AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }
}
package ru.myappco.SpringBoot.Task1.service;

import org.springframework.stereotype.Service;
import ru.myappco.SpringBoot.Task1.enums.Authorities;
import ru.myappco.SpringBoot.Task1.exception.InvalidCredentials;
import ru.myappco.SpringBoot.Task1.exception.UnauthorizedUser;
import ru.myappco.SpringBoot.Task1.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
        userRepository.init();
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
package ru.myappco.SpringBoot.Task1.repository;

import org.springframework.stereotype.Repository;
import ru.myappco.SpringBoot.Task1.entity.User;
import ru.myappco.SpringBoot.Task1.enums.Authorities;

import java.util.*;

@Repository
public class UserRepository {

    private Map<String, User> database;

    public UserRepository() {

    }

    public void init() {
        database = new HashMap<>();
        database.put("Biba", new User("Biba", "32512", Arrays.asList(Authorities.READ, Authorities.WRITE)));
        database.put("Boba", new User("Boba", "5423a", Arrays.asList(Authorities.WRITE)));
        database.put("admin", new User("admin", "admin", Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE)));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (database.containsKey(user)) {
            if (database.get(user).getPassword().equals(password))
                return database.get(user).getAuthorities();
            return new ArrayList<>();
        }
        else
            return new ArrayList<>();
    }
}

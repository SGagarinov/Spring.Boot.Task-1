package ru.myappco.SpringBoot.Task1.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.myappco.SpringBoot.Task1.domain.SystemProfile;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    private SystemProfile profile;

    public ProfileController(SystemProfile profile) {
        this.profile = profile;
    }

    @GetMapping("/")
    public String getProfile() {
        return profile.getProfile();
    }
}
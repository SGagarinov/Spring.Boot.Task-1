package ru.myappco.SpringBoot.Task1.infrastructure;

import ru.myappco.SpringBoot.Task1.domain.SystemProfile;

public class DevProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is dev";
    }
}

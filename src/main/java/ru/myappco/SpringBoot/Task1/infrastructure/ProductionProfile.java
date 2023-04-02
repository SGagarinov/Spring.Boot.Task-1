package ru.myappco.SpringBoot.Task1.infrastructure;

import ru.myappco.SpringBoot.Task1.domain.SystemProfile;

public class ProductionProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is production";
    }
}

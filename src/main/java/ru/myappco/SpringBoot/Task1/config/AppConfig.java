package ru.myappco.SpringBoot.Task1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.myappco.SpringBoot.Task1.domain.SystemProfile;
import ru.myappco.SpringBoot.Task1.infrastructure.DevProfile;
import ru.myappco.SpringBoot.Task1.infrastructure.ProductionProfile;

@Configuration
public class AppConfig {

    @Bean(name = "dev-profile")
    @ConditionalOnProperty(prefix = "netology.profile", name = "dev", havingValue = "true")
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean(name = "prod-profile")
    @ConditionalOnProperty(prefix = "netology.profile", name = "dev", havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}

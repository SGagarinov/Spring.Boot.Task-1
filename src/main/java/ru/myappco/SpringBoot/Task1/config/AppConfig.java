package ru.myappco.SpringBoot.Task1.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.myappco.SpringBoot.Task1.domain.SystemProfile;
import ru.myappco.SpringBoot.Task1.handler.UserArgumentResolver;
import ru.myappco.SpringBoot.Task1.infrastructure.DevProfile;
import ru.myappco.SpringBoot.Task1.infrastructure.ProductionProfile;

import java.util.List;

@Configuration
public class AppConfig implements WebMvcConfigurer {

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

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new UserArgumentResolver());
    }
}

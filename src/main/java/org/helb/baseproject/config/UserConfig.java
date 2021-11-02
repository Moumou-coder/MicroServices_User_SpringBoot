package org.helb.baseproject.config;

import org.helb.baseproject.model.user.User;
import org.helb.baseproject.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User Moumou = new User(
                    "Moumou",
                    "Batmou",
                    "DiamondBlack",
                    "moumou@hotmail.com",
                    "Beau123"
            );

            User Sarah = new User(
                    "Sarah",
                    "De Fleur",
                    "BxlS98",
                    "sarah@hotmail.com",
                    "Belle456"
            );

            repository.saveAll(List.of(Moumou, Sarah));
        };
    }
}

package ru.live.caprice.the;

/**
 * Created by tatiana.mayorova on 13.10.2016.
 */

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.live.caprice.the.domain.entity.Family;
import ru.live.caprice.the.domain.repository.FamilyRepository;
import ru.live.caprice.the.domain.service.FamilyService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Configuration
public class FamilyApp {


    @Bean
    public CommandLineRunner init(FamilyRepository familyRepository) {
        return (args) -> {
            List<Family> families = new ArrayList<>();
            families.add(new Family(1, "А"));
            families.add(new Family(1, "Б"));
            families.add(new Family(1, "В"));
            families.add(new Family(2, "Е"));
            families.add(new Family(2, "А"));
            families.add(new Family(2, "Д"));
            families.add(new Family(3, "У"));
            families.add(new Family(3, "Ж"));
            families.add(new Family(3, "Е"));
            families.add(new Family(3, "Б"));
            families.add(new Family(4, "Ж"));
            families.add(new Family(4, "Р"));
            families.add(new Family(5, "Я"));
            families.add(new Family(6, "Я"));
            families.add(new Family(6, "Ш"));
            families.add(new Family(7, "ООП"));

            familyRepository.save(families);
        };
    }


    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(FamilyApp.class);

        FamilyService familyService = context.getBean(FamilyService.class);
        familyService.fillFamilies();

    }


}


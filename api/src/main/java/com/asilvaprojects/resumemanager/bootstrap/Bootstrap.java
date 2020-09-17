package com.asilvaprojects.resumemanager.bootstrap;

import com.asilvaprojects.resumemanager.domain.Resume;
import com.asilvaprojects.resumemanager.repositories.ResumeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Created by andre on Sep, 2020
 */
@Component
@Slf4j
public class Bootstrap implements CommandLineRunner {


    @Autowired
    private ResumeRepository resumeRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Clean database.");
        resumeRepository.deleteAll();
        log.info("Insert bootstrap content.");
        resumeRepository.save(createResume());
    }

    private Resume createResume() {

        return new ResumeBuilder()
                .buildAddress(UUID.randomUUID().toString(),"Wellington Street", "LS1 4DL", "England")
                .buildEducation(UUID.randomUUID().toString(),"Computer Science", "School of Engineering - Polytechnic of Porto (ISEP)", LocalDate.of(2009,9,1), LocalDate.of(2013,9,1), "13")
                .buildExperince(UUID.randomUUID().toString(),"Developer & Scrum Master", "As a Senior Software Engineer I'm responsable for implement our clients requirements, helping young members, training them, interview new members.", LocalDate.of(2019, 11,1), LocalDate.now())
                .buildSkill(UUID.randomUUID().toString(),"Java", 4)
                .buildPerson(UUID.randomUUID().toString(), "Andre", "Silva", LocalDate.of(1988,6,25))
                .buildResume("I’m an energetic person always smiling and happy, I love all types of sports and I also like to travel and get to know new places and new people with their languages and culture. I consider that I get on with people very well.\n" +
                        "\n" +
                        "I'm a Portuguese guy with 32 I grew up in a small city on north of Portugal, son of an entrepreneur I grew up with an adventure spirit, hard work and devotion values");
    }
}

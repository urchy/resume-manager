package com.asilvaprojects.resumemanager.bootstrap;

import com.asilvaprojects.resumemanager.domain.*;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by andre on Sep, 2020
 */

public class ResumeBuilder {

    private Person person;
    private Address address;
    private List<Education> educations = new ArrayList<>();
    private List<Experience> experiences = new ArrayList<>();
    private List<Skill> skills = new ArrayList<>();

    public ResumeBuilder() {
    }

    public ResumeBuilder buildSkill(String id, String name, Integer level) {
        Skill skill = new Skill(id, name, level);
        this.skills.add(skill);
        return this;
    }

    public ResumeBuilder buildExperince(String id, String role, String description, LocalDate startDate, LocalDate endDate) {
        Experience experience = new Experience(id, role, description, startDate, endDate);
        this.experiences.add(experience);
        return this;
    }

    public ResumeBuilder buildEducation(String id, String degree, String instituion, LocalDate startDate, LocalDate endDate, String grade){
        Education education = new Education(id,degree,instituion,startDate,endDate, grade);
        this.educations.add(education);
        return this;
    }

    public ResumeBuilder buildAddress(String id, String street, String postalCode, String country) {
        this.address = new Address(id,street,postalCode,country);
        return this;
    }

    public ResumeBuilder buildPerson(String id, String firstName, String lastName, LocalDate birthday){
        this.person = new Person(id, firstName, lastName, birthday,this.address,this.educations,this.experiences,this.skills);
        return this;
    }

    public Resume buildResume(String presentation){
        return new Resume(UUID.randomUUID().toString(),LocalDate.now(),presentation, this.person);
    }
}

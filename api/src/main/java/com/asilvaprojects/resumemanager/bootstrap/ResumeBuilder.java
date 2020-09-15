package com.asilvaprojects.resumemanager.bootstrap;

import com.asilvaprojects.resumemanager.domain.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by andre on Sep, 2020
 */

public class ResumeBuilder {

    private Person person;
    private Address address;
    private Set<Education> educations = new HashSet<>();
    private Set<Experience> experiences = new HashSet<>();
    private Set<Skill> skills = new HashSet<>();

    public ResumeBuilder() {
    }

    public ResumeBuilder buildSkill(Long id, String name, Integer level) {
        Skill skill = new Skill(id, name, level);
        this.skills.add(skill);
        return this;
    }

    public ResumeBuilder buildExperince(Long id, String role, String description, LocalDate startDate, LocalDate endDate) {
        Experience experience = new Experience(id, role, description, startDate, endDate);
        this.experiences.add(experience);
        return this;
    }

    public ResumeBuilder buildEducation(Long id, String degree, String instituion, LocalDate startDate, LocalDate endDate, String grade){
        Education education = new Education(id,degree,instituion,startDate,endDate, grade);
        this.educations.add(education);
        return this;
    }

    public ResumeBuilder buildAddress(Long id, String street, String postalCode, String country) {
        this.address = new Address(id,street,postalCode,country);
        return this;
    }

    public ResumeBuilder buildPerson(Long id, String firstName, String lastName, LocalDate birthday){
        this.person = new Person(id, firstName, lastName, birthday,this.address,this.educations,this.experiences,this.skills);
        return this;
    }

    public Resume buildResume(String presentation){
        return new Resume(LocalDate.now(),presentation, this.person);
    }
}

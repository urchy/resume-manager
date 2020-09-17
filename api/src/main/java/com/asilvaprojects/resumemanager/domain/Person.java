package com.asilvaprojects.resumemanager.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Created by andre on Sep, 2020
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Person {
    @Id
    private String id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private LocalDate dateOfBirth;
    @NonNull
    private Address address;

    private List<Education> education;

    private List<Experience> experience;

    private List<Skill> skills;
}

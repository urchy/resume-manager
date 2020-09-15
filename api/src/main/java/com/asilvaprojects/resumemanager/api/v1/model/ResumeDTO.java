package com.asilvaprojects.resumemanager.api.v1.model;

import com.asilvaprojects.resumemanager.domain.Person;
import lombok.Data;

import java.time.LocalDate;

/**
 * Created by andre on Sep, 2020
 */

@Data
public class ResumeDTO {
    private String Id;
    private LocalDate creationDate;
    private String presentation;
    private Person person;
}

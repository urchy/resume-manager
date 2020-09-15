package com.asilvaprojects.resumemanager.api.v1.model;

import com.asilvaprojects.resumemanager.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Created by andre on Sep, 2020
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeDTO {
    private String Id;
    private LocalDate creationDate;
    private String presentation;
    private Person person;
}

package com.asilvaprojects.resumemanager.domain;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * Created by andre on Sep, 2020
 */

@Data
@Document
public class Resume {

    @Id
    private Long Id;
    @NonNull
    private LocalDate creationDate;
    @NonNull
    private String presentation;
    @NonNull
    private Person person;
}

package com.asilvaprojects.resumemanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * Created by andre on Sep, 2020
 */

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Resume {

    @Id
    private String id;
    @NonNull
    private LocalDate creationDate;
    @NonNull
    private String presentation;
    @NonNull
    private Person person;
}

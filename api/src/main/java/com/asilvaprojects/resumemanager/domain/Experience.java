package com.asilvaprojects.resumemanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * Created by andre on Sep, 2020
 */

@Data
@Document
@AllArgsConstructor
public class Experience {
    @Id
    private Long id;
    private String role;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
}

package com.asilvaprojects.resumemanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by andre on Sep, 2020
 */

@Data
@Document
@AllArgsConstructor
public class Skill {
    @Id
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Integer level;
}

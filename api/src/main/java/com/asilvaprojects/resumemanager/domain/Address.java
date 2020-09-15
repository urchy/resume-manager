package com.asilvaprojects.resumemanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by andre on Sep, 2020
 */

@Data
@AllArgsConstructor
@Document
public class Address {

    @NonNull
    private String street;
    @NonNull
    private String postalCode;
    @NonNull
    private String Country;
}


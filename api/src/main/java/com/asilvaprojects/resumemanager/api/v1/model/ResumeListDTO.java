package com.asilvaprojects.resumemanager.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by andre on Sep, 2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeListDTO {
    List<ResumeDTO> resumes;
}

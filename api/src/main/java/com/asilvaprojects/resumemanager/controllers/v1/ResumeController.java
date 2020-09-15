package com.asilvaprojects.resumemanager.controllers.v1;

import com.asilvaprojects.resumemanager.api.v1.model.ResumeListDTO;
import com.asilvaprojects.resumemanager.services.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by andre on Sep, 2020
 */

@RestController
@RequestMapping(ResumeController.BASE_URL)
public class ResumeController {

    public static final String BASE_URL = "/api/v1/resumes";

    @Autowired
    private ResumeService resumeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResumeListDTO retrieveAllResumes(){
        return new ResumeListDTO(resumeService.retrieveAllResumes());
    }

}

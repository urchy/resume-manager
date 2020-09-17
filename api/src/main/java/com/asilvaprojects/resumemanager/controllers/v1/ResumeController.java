package com.asilvaprojects.resumemanager.controllers.v1;

import com.asilvaprojects.resumemanager.api.v1.model.ResumeDTO;
import com.asilvaprojects.resumemanager.api.v1.model.ResumeListDTO;
import com.asilvaprojects.resumemanager.services.ResumeService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResumeDTO createNewResume(@RequestBody ResumeDTO resumeDTO) {
        return resumeService.createNewResume(resumeDTO);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ResumeDTO updateVendor(@PathVariable String id, @RequestBody ResumeDTO resumeDTO){
        return resumeService.saveResumeByDTO(id, resumeDTO);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteVendor(@PathVariable String id){
        resumeService.deleteResumeById(id);
    }
}

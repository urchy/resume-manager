package com.asilvaprojects.resumemanager.services;

import com.asilvaprojects.resumemanager.api.v1.mapper.ResumeMapper;
import com.asilvaprojects.resumemanager.api.v1.model.ResumeDTO;
import com.asilvaprojects.resumemanager.repositories.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by andre on Sep, 2020
 */
@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;
    private ResumeMapper resumeMapper;

    public void setResumeMapper(ResumeMapper resumempper) {
        this.resumeMapper = resumempper;
    }

    public List<ResumeDTO> retrieveAllResumes() {
        return resumeRepository.findAll()
                .stream()
                .map(resumeMapper::ResumetoResumeDTO)
                .collect(Collectors.toList());
    }
}

package com.asilvaprojects.resumemanager.services;

import com.asilvaprojects.resumemanager.api.v1.mapper.ResumeMapper;
import com.asilvaprojects.resumemanager.api.v1.model.ResumeDTO;
import com.asilvaprojects.resumemanager.repositories.ResumeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by andre on Sep, 2020
 */
@Slf4j
@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    private final ResumeMapper resumeMapper;

    public ResumeService(ResumeMapper resumeMapper) {
        this.resumeMapper = resumeMapper;
    }

    public List<ResumeDTO> retrieveAllResumes() {
        log.info("Geting all Resumes from database");
        return resumeRepository.findAll()
                .stream()
                .map(resumeMapper::ResumetoResumeDTO)
                .collect(Collectors.toList());
    }
}

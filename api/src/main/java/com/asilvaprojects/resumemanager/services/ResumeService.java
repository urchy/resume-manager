package com.asilvaprojects.resumemanager.services;

import com.asilvaprojects.resumemanager.api.v1.mapper.ResumeMapper;
import com.asilvaprojects.resumemanager.api.v1.model.ResumeDTO;
import com.asilvaprojects.resumemanager.domain.Resume;
import com.asilvaprojects.resumemanager.repositories.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andre on Sep, 2020
 */
@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    private ResumeMapper resumeMapper;

    public ResumeService(ResumeMapper resumeMapper) {
        this.resumeMapper = resumeMapper;
    }

    public List<ResumeDTO> retrieveAllResumes() {
        List<Resume> collect = resumeRepository.findAll();

        List<ResumeDTO> resumeDTOS = new ArrayList<>();

        for (Resume resume : collect) {
            resumeDTOS.add(resumeMapper.ResumetoResumeDTO(resume));
        }

        return resumeDTOS;
    }
}

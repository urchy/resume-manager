package com.asilvaprojects.resumemanager.services;

import com.asilvaprojects.resumemanager.api.v1.mapper.ResumeMapper;
import com.asilvaprojects.resumemanager.api.v1.model.ResumeDTO;
import com.asilvaprojects.resumemanager.bootstrap.ResumeBuilder;
import com.asilvaprojects.resumemanager.domain.Resume;
import com.asilvaprojects.resumemanager.repositories.ResumeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by andre on Sep, 2020
 */

class ResumeServiceTest {

    @Mock
    ResumeRepository resumeRepository;

    @InjectMocks
    ResumeService resumeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void retrieveAllResumes() {
        //given
        List<Resume> resumes = Arrays.asList(createResume(), createResume());
        when(resumeRepository.findAll()).thenReturn(resumes);

        //when
        List<ResumeDTO> resumeDTOList = resumeService.retrieveAllResumes();

        //then
        assertEquals(resumeDTOList.size(), 2);
        assertEquals(resumeDTOList.get(0).getPerson().getLastName(), "lastName");

    }

    private Resume createResume() {
        return new ResumeBuilder()
                .buildAddress("1","street", "postalCode", "country")
                .buildEducation("1","degree", "institution", LocalDate.now(), LocalDate.now().plusDays(1L), "grade")
                .buildExperince("1","role", "description", LocalDate.now().minusYears(1L), LocalDate.now())
                .buildSkill("1","skillName", 1)
                .buildPerson("1", "firstname", "lastName", LocalDate.of(1988,06,25))
                .buildResume("presentation");
    }

}

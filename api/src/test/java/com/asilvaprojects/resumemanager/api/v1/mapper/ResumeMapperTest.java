package com.asilvaprojects.resumemanager.api.v1.mapper;

import com.asilvaprojects.resumemanager.api.v1.model.ResumeDTO;
import com.asilvaprojects.resumemanager.bootstrap.ResumeBuilder;
import com.asilvaprojects.resumemanager.domain.Resume;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by andre on Sep, 2020
 */

public class ResumeMapperTest {

    private final ResumeMapper resumeMapper = ResumeMapper.INSTANCE;
    public static final String NAME = "Joe";
    public static final long ID = 1L;

    @Test
    public void giveResumeObject_returnResumeDTO() {

        //given
        final Resume resume = createResume();

        //when
        final ResumeDTO resumeDTO = resumeMapper.resumetoResumeDTO(resume);

        //then
        assertEquals(resume.getId(), resumeDTO.getId());
        assertEquals(resume.getPerson().getAddress(), resumeDTO.getPerson().getAddress());
        assertEquals(resume.getPerson().getExperience().stream().count(), 1);
        assertEquals(resume.getPerson().getAddress().getCountry(), "country");
        assertEquals(resume.getPerson().getEducation().get(0).getDegree(), "degree");
    }

    private Resume createResume() {
        return new ResumeBuilder()
                .buildAddress("1", "street", "postalCode", "country")
                .buildEducation("1", "degree", "institution", LocalDate.now(), LocalDate.now().plusDays(1L), "grade")
                .buildExperince("1", "role", "description", LocalDate.now().minusYears(1L), LocalDate.now())
                .buildSkill("1", "skillName", 1)
                .buildPerson("1", "firstname", "lastName", LocalDate.of(1988, 06, 25))
                .buildResume("presentation");
    }

}

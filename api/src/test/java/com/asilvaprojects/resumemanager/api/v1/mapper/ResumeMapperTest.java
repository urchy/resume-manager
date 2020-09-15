package com.asilvaprojects.resumemanager.api.v1.mapper;

import com.asilvaprojects.resumemanager.api.v1.model.ResumeDTO;
import com.asilvaprojects.resumemanager.bootstrap.ResumeBuilder;
import com.asilvaprojects.resumemanager.domain.Person;
import com.asilvaprojects.resumemanager.domain.Resume;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by andre on Sep, 2020
 */

public class ResumeMapperTest {

    private ResumeMapper resumeMapper = ResumeMapper.INSTANCE;
    public static final String NAME = "Joe";
    public static final long ID = 1L;

    @Test
    public void giveResumeObject_returnResumeDTO(){

        //given
        final Resume resume = createResume();

        //when
        final ResumeDTO resumeDTO = resumeMapper.PersonDTOtoPerson(resume);

        //then
        assertEquals(resume.getId(), resumeDTO.getId());
        assertEquals(resume.getPerson().getAddress(), resumeDTO.getPerson().getAddress());
        assertEquals(resume.getPerson().getExperience().stream().count(),1);
        assertEquals(resume.getPerson().getAddress().getCountry(),"country");
    }

    private Resume createResume() {
        return new ResumeBuilder()
                .buildAddress(1L,"street", "postalCode", "country")
                .buildEducation(1L,"degree", "institution", LocalDate.now(), LocalDate.now().plusDays(1L), "grade")
                .buildExperince(1L,"role", "description", LocalDate.now().minusYears(1L), LocalDate.now())
                .buildSkill(1L,"skillName", 1)
                .buildPerson(1L, "firstname", "lastName", LocalDate.of(1988,06,25))
                .buildResume("presentation");
    }

}

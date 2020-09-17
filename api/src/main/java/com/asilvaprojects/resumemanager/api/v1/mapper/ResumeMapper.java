package com.asilvaprojects.resumemanager.api.v1.mapper;


import com.asilvaprojects.resumemanager.api.v1.model.ResumeDTO;
import com.asilvaprojects.resumemanager.domain.Resume;
import com.asilvaprojects.resumemanager.services.ResumeService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by andre on Sep, 2020
 */
@Mapper(componentModel = "spring", uses = ResumeService.class)
public interface ResumeMapper {

    ResumeMapper INSTANCE = Mappers.getMapper(ResumeMapper.class);

    ResumeDTO resumetoResumeDTO(Resume resume);
    Resume resumeDTOtoResume(ResumeDTO resumeDTO);
}

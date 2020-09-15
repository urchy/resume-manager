package com.asilvaprojects.resumemanager.api.v1.mapper;


import com.asilvaprojects.resumemanager.api.v1.model.ResumeDTO;
import com.asilvaprojects.resumemanager.domain.Resume;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by andre on Sep, 2020
 */
@Mapper
public interface ResumeMapper {

    ResumeMapper INSTANCE = Mappers.getMapper(ResumeMapper.class);

    ResumeDTO PersonDTOtoPerson(Resume resume);
}

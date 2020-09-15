package com.asilvaprojects.resumemanager.repositories;

import com.asilvaprojects.resumemanager.domain.Resume;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by andre on Sep, 2020
 */
@Repository
public interface ResumeRepository extends MongoRepository<Resume, String> {
}

package eiu.edu.final_project.repository;

import eiu.edu.final_project.domain.File;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IFileRepository extends MongoRepository<File, String> {
    void saveAndFlush(File file);
    File findOne(String id);
    void delete(String id);
}

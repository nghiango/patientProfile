package eiu.edu.final_project.repository;

import eiu.edu.final_project.domain.Treatment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ITreatmentRepository extends MongoRepository<Treatment, String> {
    Treatment findOne(int id);
    void delete(int id);

    Treatment findById(int id);
}

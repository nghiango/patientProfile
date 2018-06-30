package eiu.edu.final_project.repository;

import eiu.edu.final_project.domain.Treatment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ITreatmentRepository extends MongoRepository<Treatment, String> {
    void delete(String id);

    List<Treatment> findAllTreatment();

    boolean isTreatmentExist(Treatment treatment);

    void saveTreatment(Treatment treatment);
}

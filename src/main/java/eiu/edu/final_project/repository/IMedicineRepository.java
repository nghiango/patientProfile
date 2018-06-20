package eiu.edu.final_project.repository;

import eiu.edu.final_project.domain.Medicine;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IMedicineRepository extends MongoRepository<Medicine, String> {
}

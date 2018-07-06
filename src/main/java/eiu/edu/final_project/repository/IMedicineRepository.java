package eiu.edu.final_project.repository;

import eiu.edu.final_project.domain.Medicine;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface IMedicineRepository extends MongoRepository<Medicine, String> {
    List<Medicine> findByTypeId(String medicineTypeId);
    List<Medicine> findByName(String medicineName);
}

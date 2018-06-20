package eiu.edu.final_project.repository;

import eiu.edu.final_project.domain.TypeOfMedicine;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ITypeMedicineRepository extends MongoRepository<TypeOfMedicine, String> {
}

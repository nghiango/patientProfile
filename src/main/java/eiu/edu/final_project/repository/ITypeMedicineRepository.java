package eiu.edu.final_project.repository;

import eiu.edu.final_project.domain.TypeOfMedicine;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ITypeMedicineRepository extends MongoRepository<TypeOfMedicine, String> {
    Optional<TypeOfMedicine> findByTypeName(String typeName);
}

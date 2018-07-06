package eiu.edu.final_project.repository;

import eiu.edu.final_project.domain.TypeOfMedicine;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ITypeMedicineRepository extends MongoRepository<TypeOfMedicine, String> {
    List<TypeOfMedicine> findByTypeName(String typeName);
}

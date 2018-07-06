package eiu.edu.final_project.repository;

import eiu.edu.final_project.domain.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface IPatientRepository extends MongoRepository<Patient, String> {
    List<Patient> findByFullName(String name);
}

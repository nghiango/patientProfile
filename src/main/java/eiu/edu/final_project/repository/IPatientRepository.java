package eiu.edu.final_project.repository;

import eiu.edu.final_project.domain.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IPatientRepository extends MongoRepository<Patient, String> {
    Optional<Patient> findByFullName(String name);
}

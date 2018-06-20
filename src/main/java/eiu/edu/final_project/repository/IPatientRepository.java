package eiu.edu.final_project.repository;

import eiu.edu.final_project.domain.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPatientRepository extends MongoRepository<Patient, String> {
    Patient findByFullName(String name);
}

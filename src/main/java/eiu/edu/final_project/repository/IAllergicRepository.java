package eiu.edu.final_project.repository;

import eiu.edu.final_project.domain.Allergic;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IAllergicRepository extends MongoRepository<Allergic, String> {
}

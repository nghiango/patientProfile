package eiu.edu.final_project.repository;

import eiu.edu.final_project.domain.Roles;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IRoleRepository extends MongoRepository<Roles, String> {
}

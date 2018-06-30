package eiu.edu.final_project.repository;

import eiu.edu.final_project.domain.History;
import eiu.edu.final_project.domain.Roles;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IRoleRepository extends MongoRepository<Roles, String> {
}

package eiu.edu.final_project.repository;

import eiu.edu.final_project.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserRepository extends MongoRepository<User, String> {
}

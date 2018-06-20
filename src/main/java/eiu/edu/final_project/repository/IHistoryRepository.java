package eiu.edu.final_project.repository;

import eiu.edu.final_project.domain.History;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IHistoryRepository extends MongoRepository<History, String> {
}

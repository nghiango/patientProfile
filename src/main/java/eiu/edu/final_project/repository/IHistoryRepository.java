package eiu.edu.final_project.repository;

import eiu.edu.final_project.domain.History;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface IHistoryRepository extends MongoRepository<History, String> {
}

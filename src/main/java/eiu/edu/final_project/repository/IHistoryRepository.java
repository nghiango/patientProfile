package eiu.edu.final_project.repository;

import eiu.edu.final_project.domain.History;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface IHistoryRepository extends MongoRepository<History, String> {
    Optional<History> findById(String id);

//	List<History> findBytreatmentId(int id);

    void saveHistory(History history);

    void updateHistory(History history);

    Optional<History> deleteHistoryById(String id);

    void deleteAllHistory();

    List<History> findAllHistorys();

    boolean isMedicineExist(History history);
}

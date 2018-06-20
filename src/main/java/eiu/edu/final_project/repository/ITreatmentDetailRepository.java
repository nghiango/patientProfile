package eiu.edu.final_project.repository;

import eiu.edu.final_project.domain.TreatmentDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ITreatmentDetailRepository extends MongoRepository<TreatmentDetail, String> {
}

package eiu.edu.final_project.repository;

import eiu.edu.final_project.domain.TreatmentDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ITreatmentDetailRepository extends MongoRepository<TreatmentDetail, String> {
    boolean isTreatmentDetailExist(TreatmentDetail treatmentDetail);
    void delete(String id);
}

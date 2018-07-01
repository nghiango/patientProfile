package eiu.edu.final_project.service.serviceInterface;

import java.util.List;

import eiu.edu.final_project.domain.TreatmentDetail;

public interface ITreatmentDtService {
	
	TreatmentDetail findById(String id);
	 
    TreatmentDetail findByName(String name);
 
    void saveTreatmentDt(TreatmentDetail treatmentdt);
 
    void updateTreatmentDt(String treatmentDtId, TreatmentDetail treatmentDt);
 
    void deleteTreatmentDtById(String id);
 
    void deleteAllTreatmentDt();
 
    List<TreatmentDetail> findAllTreatmentDt();
    
//    List<Object[]> findNotAllergic(int id);
 
    boolean isTreatmentDtExist(TreatmentDetail treatmentdt);

}

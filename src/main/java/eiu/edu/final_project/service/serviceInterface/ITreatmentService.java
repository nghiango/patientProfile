package eiu.edu.final_project.service.serviceInterface;

import java.util.List;
import eiu.edu.final_project.domain.Treatment;

public interface ITreatmentService {
	
	Treatment findById(String id);
	 
    Treatment findByName(String name);
 
    void saveTreatment(Treatment treatment);
 
    void updateTreatment(Treatment treatment);
 
    void deleteTreatmentById(String id);
 
    void deleteAllTreatment();
 
    List<Treatment> findAllTreatment();
 
    boolean isTreatmentExist(Treatment treatment);

}

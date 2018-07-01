package eiu.edu.final_project.service.serviceInterface;

import java.util.List;

import eiu.edu.final_project.domain.History;

public interface IHistoryService {
	History findById(String id);
	 
//	List<History> findBytreatmentId(int id);
 
    void saveHistory(History history);
 
    void updateHistory(History history);
 
    void deleteHistoryById(String id);
 
    void deleteAllHistory();
 
    List<History> findAllHistorys();

    boolean isHistoryExist(History history);
 
    boolean isMedicineExist(History history);
}

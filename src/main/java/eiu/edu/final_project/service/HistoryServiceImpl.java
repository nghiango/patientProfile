package eiu.edu.final_project.service;

import java.util.List;
import java.util.Optional;

import eiu.edu.final_project.domain.History;
import eiu.edu.final_project.repository.IHistoryRepository;
import eiu.edu.final_project.service.serviceInterface.IHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryServiceImpl implements IHistoryService {
	
	@Autowired
	IHistoryRepository iHistoryRepository;

//	@Override
//	public List<History> findBytreatmentId(int id) {
//		return historyRepository.findByTreatmentId(id);
//	}

	@Override
	public History findById(String id) {
		Optional<History> history = iHistoryRepository.findById(id);
		if (history.isPresent()){
			return history.get();
		}
		return new History();
	}

	@Override
	public void saveHistory(History history) {
		iHistoryRepository.save(history);
		
	}

	@Override
	public void updateHistory(History history) {
		saveHistory(history);
		
	}

	@Override
	public void deleteHistoryById(String id) {
		iHistoryRepository.deleteHistoryById(id);
		
	}

	@Override
	public void deleteAllHistory() {
		iHistoryRepository.deleteAll();
		
	}

	@Override
	public List<History> findAllHistorys() {
		return (List<History>) iHistoryRepository.findAll();
	}

	@Override
	public boolean isMedicineExist(History history) {
		// TODO Auto-generated method stub
		return false;
	}


}

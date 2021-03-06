package eiu.edu.final_project.controller;

import java.util.List;

import eiu.edu.final_project.domain.History;
import eiu.edu.final_project.repository.IHistoryRepository;
import eiu.edu.final_project.service.HistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HistoryController {

	@Autowired
	HistoryServiceImpl historyService;

	// ======================== Get All History========================

	@RequestMapping(value = "/history", method = RequestMethod.GET)
	public List<History> getListHistory() {
		List<History> histories = historyService.findAllHistorys();
		return histories;
	}
	
//	=========================Find History By Treatment Id===========
	
//	@RequestMapping(value="/history/{id}", method = RequestMethod.GET)
//	public History getHistoryByTreatmentId(@PathVariable("id") String id){
//		List<History> history = historyService.findBytreatmentId(id);
//		if(history==null){
//			 logger.error("Patient with id {} not found.", id);
//			 return new ResponseEntity(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<List<History>>(history, HttpStatus.OK);
//	}
	
	// ======================== Create History ========================

	@RequestMapping(value = "/history", method = RequestMethod.POST)
	public History createHistory(@RequestBody History history) {
		if(!historyService.isHistoryExist(history)){
			historyService.saveHistory(history);
		}
		return new History();
	}

}

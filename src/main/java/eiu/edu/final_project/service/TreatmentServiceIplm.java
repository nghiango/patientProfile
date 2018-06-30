package eiu.edu.final_project.service;

import java.util.List;
import java.util.Optional;

import eiu.edu.final_project.domain.Treatment;
import eiu.edu.final_project.repository.ITreatmentRepository;
import eiu.edu.final_project.service.serviceInterface.ITreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;;

@Service("treatmentService")
@Transactional
public class TreatmentServiceIplm implements ITreatmentService {

	@Autowired
    private ITreatmentRepository iTreatmentRepository;

	@Override
	public Treatment findById(String id) {
		Optional<Treatment> treatment = iTreatmentRepository.findById(id);
		if (treatment.isPresent()){
			return treatment.get();
		}
		return new Treatment();
	}

	@Override
	public Treatment findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveTreatment(Treatment treatment) {
		iTreatmentRepository.save(treatment);
		
	}

	@Override
	public void updateTreatment(Treatment treatment) {
		saveTreatment(treatment);
		
	}

	@Override
	public void deleteTreatmentById(String id) {
		iTreatmentRepository.delete(id);
	}

	@Override
	public void deleteAllTreatment() {
		iTreatmentRepository.deleteAll();
		
	}

	@Override
	public List<Treatment> findAllTreatment() {
		return iTreatmentRepository.findAll();
	}
  
	@Override
	public boolean isTreatmentExist(Treatment treatment) {
		return findById(treatment.getId()) != null;
	}
}
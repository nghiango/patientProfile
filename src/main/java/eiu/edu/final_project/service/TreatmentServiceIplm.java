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
    private ITreatmentRepository treatmentRepository;

	@Override
	public Treatment findById(String id) {
		Optional<Treatment> treatment = treatmentRepository.findById(id);
		if (treatment.isPresent()){
			return treatment.get();
		}
		return new Treatment();
	}

	@Override
	public Treatment findByName(String name) {
		return null;
	}

	@Override
	public void saveTreatment(Treatment treatment) {
		treatmentRepository.save(treatment);
	}

	@Override
	public void updateTreatment(String treatmentId, Treatment treatment) {
		treatment.setId(treatmentId);
		saveTreatment(treatment);
	}

	@Override
	public void deleteTreatmentById(String id) {
		treatmentRepository.deleteById(id);
	}

	@Override
	public void deleteAllTreatment() {
		treatmentRepository.deleteAll();
	}

	@Override
	public List<Treatment> findAllTreatment() {
		return treatmentRepository.findAll();
	}
  
	@Override
	public boolean isTreatmentExist(Treatment treatment) {
		return findById(treatment.getId()) != null;
	}
}
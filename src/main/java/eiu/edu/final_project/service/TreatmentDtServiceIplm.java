package eiu.edu.final_project.service;

import java.util.List;

import eiu.edu.final_project.domain.TreatmentDetail;
import eiu.edu.final_project.repository.ITreatmentDetailRepository;
import eiu.edu.final_project.service.serviceInterface.ITreatmentDtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;


@Service("treatmentDtService")
@Transactional

public class TreatmentDtServiceIplm implements ITreatmentDtService {
	
	@Autowired
    private ITreatmentDetailRepository iTreatmentDetailRepository;

	@Override
	public TreatmentDetail findById(int id) {
		return iTreatmentDetailRepository.findOne(id);
	}

	@Override
	public TreatmentDetail findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveTreatmentDt(TreatmentDetail treatmentdt) {
		iTreatmentDetailRepository.save(treatmentdt);
		
	}

	@Override
	public void updateTreatmentDt(TreatmentDetail treatmentdt) {
		saveTreatmentDt(treatmentdt);
		
	}

	@Override
	public void deleteTreatmentDtById(int id) {
		iTreatmentDetailRepository.delete(id);
		
	}

	@Override
	public void deleteAllTreatmentDt() {
		iTreatmentDetailRepository.deleteAll();
		
	}

	@Override
	public List<TreatmentDetail> findAllTreatmentDt() {
		return (List<TreatmentDetail>) iTreatmentDetailRepository.findAll();
	}

	@Override
	public boolean isTreatmentDtExist(TreatmentDetail treatmentdt) {
		return findById(treatmentdt.getId()) != null;
	}

	@Override
	public List<Object[]> findNotAllergic(int id) {
		return iTreatmentDetailRepository.findNotAllergic(id);
	}
	
	
	

}

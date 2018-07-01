package eiu.edu.final_project.service;

import java.util.List;
import java.util.Optional;

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
	public TreatmentDetail findById(String id) {
		Optional<TreatmentDetail> treatmentDetail = iTreatmentDetailRepository.findById(id);
		if (treatmentDetail.isPresent()){
			return treatmentDetail.get();
		}
		return new TreatmentDetail();
	}

	@Override
	public TreatmentDetail findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveTreatmentDt(TreatmentDetail treatmentDt) {
		iTreatmentDetailRepository.save(treatmentDt);
		
	}

	@Override
	public void updateTreatmentDt(TreatmentDetail treatmentDt) {
		saveTreatmentDt(treatmentDt);
		
	}

	@Override
	public void deleteTreatmentDtById(String id) {
		iTreatmentDetailRepository.deleteById(id);
		
	}

	@Override
	public void deleteAllTreatmentDt() {
		iTreatmentDetailRepository.deleteAll();
		
	}

	@Override
	public List<TreatmentDetail> findAllTreatmentDt() {
		return iTreatmentDetailRepository.findAll();
	}

	@Override
	public boolean isTreatmentDtExist(TreatmentDetail treatmentDt) {
		return findById(treatmentDt.getId()) != null;
	}

//	@Override
//	public List<Object[]> findNotAllergic(int id) {
//		return iTreatmentDetailRepository.findNotAllergic(id);
//	}

}

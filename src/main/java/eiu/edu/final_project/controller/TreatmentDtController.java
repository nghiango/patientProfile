package eiu.edu.final_project.controller;

import java.util.List;
import java.util.Optional;

import eiu.edu.final_project.domain.TreatmentDetail;
import eiu.edu.final_project.repository.ITreatmentDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TreatmentDtController {
    @Autowired
    ITreatmentDetailRepository treatmentDetailRepository;
    // -------------------Retrieve All TreatmentDt---------------------------------------------
 
    @RequestMapping(value = "/treatmentDt", method = RequestMethod.GET)
    public List<TreatmentDetail> getAllTreatmentDt() {
        List<TreatmentDetail> treatmentsDt = treatmentDetailRepository.findAll();
        return treatmentsDt;
    }
 
    // -------------------Retrieve Single TreatmentDt------------------------------------------
 
    @RequestMapping(value = "/treatmentDt/{id}", method = RequestMethod.GET)
    public TreatmentDetail getTreatmentDtById(@PathVariable("id") String id) {
        Optional<TreatmentDetail> treatmentDt = treatmentDetailRepository.findById(id);
        if (treatmentDt.isPresent()) {
            return treatmentDt.get();
        }
        return new TreatmentDetail();
    }
    
 //// -------------------Create a TreatmentDt-------------------------------------------
 
    @RequestMapping(value = "/treatmentDt", method = RequestMethod.POST)
    public TreatmentDetail treatmentDt(@RequestBody TreatmentDetail treatmentDt) {
        if (!treatmentDetailRepository.isTreatmentDetailExist(treatmentDt)) {
            return treatmentDetailRepository.save(treatmentDt);
        }
        return new TreatmentDetail();
    }
 
    // ------------------- Update a TreatmentDt ------------------------------------------------
 
    @RequestMapping(value = "/treatmentDt/{id}", method = RequestMethod.PUT)
    public TreatmentDetail updateTreatmentDt(@PathVariable("id") String id, @RequestBody TreatmentDetail treatmentDt) {
        Optional<TreatmentDetail> currentTreatmentDetail = treatmentDetailRepository.findById(id);
        if (treatmentDetailRepository.isTreatmentDetailExist(currentTreatmentDetail.get())) {
            return treatmentDetailRepository.save(treatmentDt);
        }
        return null;
    }
 
    // ------------------- Delete a TreatmentDt-----------------------------------------
 
    @RequestMapping(value = "/treatmentDt/{id}", method = RequestMethod.DELETE)
    public void deleteTreatmentDt(@PathVariable("id") String id) {
        treatmentDetailRepository.delete(id);
    }
 
    // ------------------- Delete All TreatmentDt-----------------------------
 
    @RequestMapping(value = "/treatmentDt", method = RequestMethod.DELETE)
    public void deleteAllTreatmentDt() {
        treatmentDetailRepository.deleteAll();
    }
}
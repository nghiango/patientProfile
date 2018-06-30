package eiu.edu.final_project.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import eiu.edu.final_project.domain.Medicine;
import eiu.edu.final_project.domain.Treatment;
import eiu.edu.final_project.domain.TreatmentDetail;
import eiu.edu.final_project.repository.ITreatmentDetailRepository;
import eiu.edu.final_project.service.serviceInterface.ITreatmentDtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.swing.text.html.Option;

@RestController
public class TreatmentDtController {
 
    public static final Logger logger = LoggerFactory.getLogger(TreatmentDtController.class);
 
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
        Optional<TreatmentDetail> treatmentDt = treatmentDetailRepository.findById(id);
        treatmentDetailRepository.delete(id);
    }
 
    // ------------------- Delete All TreatmentDt-----------------------------
 
    @RequestMapping(value = "/treatmentDt", method = RequestMethod.DELETE)
    public void deleteAllTreatmentDt() {
        treatmentDetailRepository.deleteAll();
    }
}
package eiu.edu.final_project.controller;

import eiu.edu.final_project.domain.Treatment;
import eiu.edu.final_project.repository.ITreatmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class TreatmentController {

    public static final Logger logger = LoggerFactory.getLogger(TreatmentController.class);

    @Autowired
    ITreatmentRepository treatmentRepository; //Service which will do all data retrieval/manipulation work
 
    // -------------------Retrieve All Treatment---------------------------------------------
 
    @RequestMapping(value = "/treatment", method = RequestMethod.GET)
    public List<Treatment> listAllTreatment() {
        List<Treatment> treatment = treatmentRepository.findAllTreatment();
        return treatment;
    }

    @RequestMapping(value = "/treatment/{id}", method = RequestMethod.GET)
    public Treatment getTreatmentById(@PathVariable("id") String id) {
        Optional<Treatment> treatment = treatmentRepository.findById(id);
        if (treatment.isPresent()) {
            return treatment.get();
        }
        return new Treatment();
    }
 
    // -------------------Create a Treatment-------------------------------------------
 
    @RequestMapping(value = "/treatment", method = RequestMethod.POST)
    public Treatment createTreatment(@RequestBody Treatment treatment) {
        if (!treatmentRepository.isTreatmentExist(treatment)) {
            return treatmentRepository.save(treatment);
        }
        return new Treatment();
    }
 
    // ------------------- Update a Treatment ------------------------------------------------
 
    @RequestMapping(value = "/treatment/{id}", method = RequestMethod.PUT)
    public Treatment updateTreatment(@PathVariable("id") String id, @RequestBody Treatment treatment) {
        Optional<Treatment> currentTreatment = treatmentRepository.findById(id);
        if (treatmentRepository.isTreatmentExist(currentTreatment.get())) {
            return treatmentRepository.save(treatment);
        }
        return null;
    }
 
    // ------------------- Delete a Treatment-----------------------------------------
 
    @RequestMapping(value = "/treatment/{id}", method = RequestMethod.DELETE)
    public void deleteTreatment(@PathVariable("id") String id) {
        treatmentRepository.delete(id);
    }
 
    // ------------------- Delete All Treatment-----------------------------
 
    @RequestMapping(value = "/treatment", method = RequestMethod.DELETE)
    public void deleteAllTreatment() {
        treatmentRepository.deleteAll();
    }
}
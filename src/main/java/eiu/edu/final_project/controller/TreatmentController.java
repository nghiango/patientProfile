package eiu.edu.final_project.controller;

import eiu.edu.final_project.domain.Treatment;
import eiu.edu.final_project.repository.ITreatmentRepository;
import eiu.edu.final_project.service.TreatmentServiceIplm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TreatmentController {


    @Autowired
    TreatmentServiceIplm treatmentServiceIplm; //Service which will do all data retrieval/manipulation work

    // -------------------Retrieve All Treatment---------------------------------------------

    @RequestMapping(value = "/treatment", method = RequestMethod.GET)
    public List<Treatment> listAllTreatment() {
        List<Treatment> treatment = treatmentServiceIplm.findAllTreatment();
        return treatment;
    }

    @RequestMapping(value = "/treatment/{id}", method = RequestMethod.GET)
    public Treatment getTreatmentById(@PathVariable("id") String id) {
        return treatmentServiceIplm.findById(id);
    }

    // -------------------Create a Treatment-------------------------------------------

    @RequestMapping(value = "/treatment", method = RequestMethod.POST)
    public Treatment createTreatment(@RequestBody Treatment treatment) {
        if (!treatmentServiceIplm.isTreatmentExist(treatment)) {
            treatmentServiceIplm.saveTreatment(treatment);
        }
        return new Treatment();
    }

    // ------------------- Update a Treatment ------------------------------------------------

    @RequestMapping(value = "/treatment/{id}", method = RequestMethod.PUT)
    public Treatment updateTreatment(@PathVariable String treatmentId, @RequestBody Treatment treatment) {
        treatmentServiceIplm.updateTreatment(treatmentId, treatment);
        return null;
    }

    // ------------------- Delete a Treatment-----------------------------------------

    @RequestMapping(value = "/treatment/{id}", method = RequestMethod.DELETE)
    public void deleteTreatment(@PathVariable("id") String id) {
        treatmentServiceIplm.deleteTreatmentById(id);
    }

    // ------------------- Delete All Treatment-----------------------------

    @RequestMapping(value = "/treatment", method = RequestMethod.DELETE)
    public void deleteAllTreatment() {
        treatmentServiceIplm.deleteAllTreatment();
    }
}
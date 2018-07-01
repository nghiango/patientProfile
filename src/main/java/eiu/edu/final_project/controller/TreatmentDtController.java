package eiu.edu.final_project.controller;


import java.util.List;
import java.util.Optional;

import eiu.edu.final_project.domain.TreatmentDetail;
import eiu.edu.final_project.repository.ITreatmentDetailRepository;
import eiu.edu.final_project.service.TreatmentDtServiceIplm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TreatmentDtController {

    @Autowired
    TreatmentDtServiceIplm treatmentDtServiceIplm;
    // -------------------Retrieve All TreatmentDt---------------------------------------------

    @RequestMapping(value = "/treatmentDt", method = RequestMethod.GET)
    public List<TreatmentDetail> getAllTreatmentDt() {
        List<TreatmentDetail> treatmentsDt = treatmentDtServiceIplm.findAllTreatmentDt();
        return treatmentsDt;
    }

    // -------------------Retrieve Single TreatmentDt------------------------------------------

    @RequestMapping(value = "/treatmentDt/{id}", method = RequestMethod.GET)
    public TreatmentDetail getTreatmentDtById(@PathVariable("id") String id) {
        TreatmentDetail treatmentDt = treatmentDtServiceIplm.findById(id);
        return treatmentDt;
    }

    //// -------------------Create a TreatmentDt-------------------------------------------

    @RequestMapping(value = "/treatmentDt", method = RequestMethod.POST)
    public TreatmentDetail treatmentDt(@RequestBody TreatmentDetail treatmentDt) {
        if (!treatmentDtServiceIplm.isTreatmentDtExist(treatmentDt)) {
            treatmentDtServiceIplm.saveTreatmentDt(treatmentDt);
        }
        return new TreatmentDetail();
    }

    // ------------------- Update a TreatmentDt ------------------------------------------------

    @RequestMapping(value = "/treatmentDt/{id}", method = RequestMethod.PUT)
    public TreatmentDetail updateTreatmentDt(@PathVariable String treatmentDtId, @RequestBody TreatmentDetail treatmentDt) {
        treatmentDtServiceIplm.updateTreatmentDt(treatmentDtId, treatmentDt);
        return null;
    }

    // ------------------- Delete a TreatmentDt-----------------------------------------

    @RequestMapping(value = "/treatmentDt/{id}", method = RequestMethod.DELETE)
    public void deleteTreatmentDt(@PathVariable("id") String id) {
        treatmentDtServiceIplm.deleteTreatmentDtById(id);
    }

    // ------------------- Delete All TreatmentDt-----------------------------

    @RequestMapping(value = "/treatmentDt", method = RequestMethod.DELETE)
    public void deleteAllTreatmentDt() {
        treatmentDtServiceIplm.deleteAllTreatmentDt();
    }
}
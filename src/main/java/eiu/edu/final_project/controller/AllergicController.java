package eiu.edu.final_project.controller;

import eiu.edu.final_project.domain.Allergic;
import eiu.edu.final_project.domain.Medicine;
import eiu.edu.final_project.domain.Patient;
import eiu.edu.final_project.service.AllergicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/allergic")
public class AllergicController {

    @Autowired
    AllergicServiceImpl allergicService;

    @RequestMapping
    public List<Allergic> getAllAllergic(){
        return allergicService.findAllAllergic();
    }

    @RequestMapping(value = "/{id}")
    public Allergic getAllergic(@PathVariable String id){
        Allergic allergic = allergicService.findAllergicById(id);
        return allergic;
    }

    @RequestMapping(value = "/addAllergic", method = RequestMethod.POST)
    public void addAllergic(@RequestBody String medicineId, @RequestBody String patientId){
        Medicine medicine =  allergicService.findMedicineById(medicineId);
        Patient patient =  allergicService.findPatientById(patientId);
        if (medicine.getId() != null && patient.getId() != null){
            allergicService.addAllergic(medicine, patient);
        }
    }
}

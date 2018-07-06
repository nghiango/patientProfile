package eiu.edu.final_project.controller;

import eiu.edu.final_project.domain.Patient;
import eiu.edu.final_project.service.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    PatientServiceImpl patientService;

    @RequestMapping(value = "/patients")
    public List<Patient> getAllPatients(){
        return patientService.findAllPatients();
    }

    @RequestMapping(value = "/patient/{id}")
    public Patient getPatient(@PathVariable String patientId) {
        return patientService.findPatientById(patientId);
    }

    @RequestMapping(value = "patient", method = RequestMethod.POST)
    public void createPatient(@RequestBody Patient patient){
        patientService.savePatient(patient);
    }

    @RequestMapping(value = "/patient/{id}", method = RequestMethod.PUT)
    public void updatePatient(@PathVariable String id, @RequestBody Patient patient){
        patientService.updatePatient(id, patient);
    }
}

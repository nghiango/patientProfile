package eiu.edu.final_project.service;

import eiu.edu.final_project.domain.Patient;
import eiu.edu.final_project.repository.IPatientRepository;
import eiu.edu.final_project.service.serviceInterface.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("patientService")
public class PatientServiceImpl implements IPatientService {
    @Autowired
    IPatientRepository patientRepository;
    @Override
    public Patient getPatientById(String patientId) {
        Optional<Patient> patient = patientRepository.findById(patientId);
        if (patient.isPresent()){
            return patient.get();
        }
        return new Patient();
    }
}

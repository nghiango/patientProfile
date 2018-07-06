package eiu.edu.final_project.service;

import eiu.edu.final_project.domain.Patient;
import eiu.edu.final_project.repository.IPatientRepository;
import eiu.edu.final_project.service.serviceInterface.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("patientService")
public class PatientServiceImpl implements IPatientService {

    @Autowired
    IPatientRepository patientRepository;

    @Override
    public Patient findPatientById(String patientId) {
        Optional<Patient> patient = patientRepository.findById(patientId);
        if (patient.isPresent()) {
            return patient.get();
        }
        return new Patient();
    }

    @Override
    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient savePatient(Patient patient) {
        if (isExistPatient(patient)) {
            return new Patient();
        }
        return patientRepository.save(patient);
    }

    @Override
    public void updatePatient(String id, Patient currentPatient) {
        currentPatient.setId(id);
        patientRepository.save(currentPatient);
    }

    private boolean isExistPatient(Patient patient) {
        return false;
    }
}

package eiu.edu.final_project.service.serviceInterface;

import eiu.edu.final_project.domain.Patient;

import java.util.List;

public interface IPatientService {

    Patient findPatientById(String patientId);

    List<Patient> findAllPatients();

    Patient savePatient(Patient patient);

    void updatePatient(String id, Patient patient);
}

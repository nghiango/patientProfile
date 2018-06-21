package eiu.edu.final_project.service.serviceInterface;

import eiu.edu.final_project.domain.Patient;

public interface IPatientService {
    Patient getPatientById(String patientId);
}

package eiu.edu.final_project.service.serviceInterface;

import eiu.edu.final_project.domain.Allergic;
import eiu.edu.final_project.domain.Medicine;
import eiu.edu.final_project.domain.Patient;

import java.util.List;
import java.util.Optional;

public interface IAllergicService {

    public List<Allergic> getAllAllergic();

    public Allergic getAllergic(String id);

    Medicine getMedicineById(String medicineId);

    Patient getPatientById(String patientId);

    void addAllergic(Medicine medicine, Patient patient);
}

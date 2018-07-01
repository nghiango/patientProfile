package eiu.edu.final_project.service.serviceInterface;

import eiu.edu.final_project.domain.Allergic;
import eiu.edu.final_project.domain.Medicine;
import eiu.edu.final_project.domain.Patient;

import java.util.List;
import java.util.Optional;

public interface IAllergicService {

    public List<Allergic> findAllAllergic();

    public Allergic findAllergicById(String id);

    Medicine findMedicineById(String medicineId);

    Patient findPatientById(String patientId);

    void addAllergic(Medicine medicine, Patient patient);
}

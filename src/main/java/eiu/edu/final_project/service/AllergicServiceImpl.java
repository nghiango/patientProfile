package eiu.edu.final_project.service;

import eiu.edu.final_project.domain.Allergic;
import eiu.edu.final_project.domain.Medicine;
import eiu.edu.final_project.domain.Patient;
import eiu.edu.final_project.repository.IAllergicRepository;
import eiu.edu.final_project.service.serviceInterface.IAllergicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("allergicService")
public class AllergicServiceImpl implements IAllergicService {

    @Autowired
    IAllergicRepository allergicRepository;

    @Autowired
    MedicineServiceImpl medicineService;

    @Autowired
    PatientServiceImpl patientService;

    @Override
    public List<Allergic> getAllAllergic() {
        return allergicRepository.findAll();
    }

    @Override
    public Allergic getAllergic(String id) {
        Optional<Allergic> allergic = allergicRepository.findById(id);
        if (allergic.isPresent()){
            return allergic.get();
        }
        return new Allergic();
    }

    @Override
    public Medicine getMedicineById(String medicineId) {
        return medicineService.getMedicinById(medicineId);
    }

    @Override
    public Patient getPatientById(String patientId) {
        return patientService.getPatientById(patientId);
    }

    @Override
    public void addAllergic(Medicine medicine, Patient patient) {
        Allergic allergic = new Allergic();
        allergic.setMedicineId(medicine);
        allergic.setPatientId(patient);
        allergicRepository.save(allergic);
    }
}

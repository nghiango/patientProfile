package eiu.edu.final_project.service;

import eiu.edu.final_project.domain.Medicine;
import eiu.edu.final_project.repository.IMedicineRepository;
import eiu.edu.final_project.service.serviceInterface.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("medicineService")
public class MedicineServiceImpl implements IMedicineService {
    @Autowired
    IMedicineRepository medicineRepository;
    @Override
    public Medicine getMedicinById(String medicineId) {
        Optional<Medicine> medicine = medicineRepository.findById(medicineId);
        if (medicine.isPresent()){
            return medicine.get();
        }
        return new Medicine();
    }
}

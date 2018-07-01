package eiu.edu.final_project.service;

import eiu.edu.final_project.domain.Medicine;
import eiu.edu.final_project.repository.IMedicineRepository;
import eiu.edu.final_project.service.serviceInterface.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("medicineService")
public class MedicineServiceImpl implements IMedicineService {

    @Autowired
    IMedicineRepository medicineRepository;

    @Override
    public Medicine findMedicinById(String medicineId) {
        Optional<Medicine> medicine = medicineRepository.findById(medicineId);
        if (medicine.isPresent()){
            return medicine.get();
        }
        return new Medicine();
    }

    @Override
    public List<Medicine> findAllMedicine() {
        return medicineRepository.findAll();
    }

    @Override
    public List<Medicine> findAllMedicineByType(String medicineTypeId) {
        return medicineRepository.findByTypeId(medicineTypeId);
    }

    @Override
    public boolean isMedicineExist(Medicine medicine) {
        return medicineRepository.findByName(medicine.getName()).isPresent();
    }

    @Override
    public Medicine saveMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    @Override
    public void deleteMedicineById(String id) {
        medicineRepository.deleteById(id);
    }

    @Override
    public void deleteAllMedicines() {
        medicineRepository.deleteAll();
    }

    @Override
    public void updateMedicine(String medicineId,Medicine currentMedicine) {
        currentMedicine.setId(medicineId);
        medicineRepository.save(currentMedicine);
    }
}

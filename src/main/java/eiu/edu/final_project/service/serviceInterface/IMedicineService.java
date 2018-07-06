package eiu.edu.final_project.service.serviceInterface;

import eiu.edu.final_project.domain.Medicine;

import java.util.List;

public interface IMedicineService {

    Medicine findMedicinById(String medicineId);

    List<Medicine> findAllMedicine();

    List<Medicine> findAllMedicineByType(String medicineTypeId);

    boolean isMedicineExist(Medicine medicine);

    Medicine saveMedicine(Medicine medicine);

    void deleteMedicineById(String id);

    void deleteAllMedicines();

    void updateMedicine(String medicineId, Medicine currentMedicine);
}

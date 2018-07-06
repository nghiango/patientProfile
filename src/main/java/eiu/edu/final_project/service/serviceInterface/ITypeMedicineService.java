package eiu.edu.final_project.service.serviceInterface;

import java.util.List;
import eiu.edu.final_project.domain.TypeOfMedicine;

public interface ITypeMedicineService {
	TypeOfMedicine findById(String id);
	 
	List<TypeOfMedicine> findByName(String name);
 
    void saveTypeMedicine(TypeOfMedicine typeMedicine);
 
    void updateTypeMedicine(String typeMedicineId, TypeOfMedicine typeMedicine);
 
    void deleteTypeMedicineById(String id);
 
    void deleteAllTypeMedicines();
 
    List<TypeOfMedicine> findAllTypeMedicines();
 
    boolean isTypeMedicineExist(TypeOfMedicine typeMedicine);
}

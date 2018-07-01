package eiu.edu.final_project.service;

import java.util.List;
import java.util.Optional;

import eiu.edu.final_project.domain.TypeOfMedicine;
import eiu.edu.final_project.repository.ITypeMedicineRepository;
import eiu.edu.final_project.service.serviceInterface.ITypeMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("typeMedicineService")
public class TypeMedicineServiceImpl implements ITypeMedicineService {
	
	@Autowired
	ITypeMedicineRepository typeMedicineRepository;

	@Override
	public TypeOfMedicine findById(String id) {
		Optional<TypeOfMedicine> typeOfMedicine = typeMedicineRepository.findById(id);
		if (typeOfMedicine.isPresent()){
			return typeOfMedicine.get();
		}
		return new TypeOfMedicine();
	}

	@Override
	public TypeOfMedicine findByName(String name) {
		Optional<TypeOfMedicine> typeOfMedicine = typeMedicineRepository.findByTypeName(name);
		if (typeOfMedicine.isPresent()){
			return typeOfMedicine.get();
		}
		return new TypeOfMedicine();
	}

	@Override
	public void saveTypeMedicine(TypeOfMedicine typeMedicine) {
		typeMedicineRepository.save(typeMedicine);
	}

	@Override
	public void updateTypeMedicine(String typeMedicineId, TypeOfMedicine typeMedicine) {
		typeMedicine.setId(typeMedicineId);
		saveTypeMedicine(typeMedicine);
	}

	@Override
	public void deleteTypeMedicineById(String id) {
		typeMedicineRepository.deleteById(id);
	}

	@Override
	public void deleteAllTypeMedicines() {
		typeMedicineRepository.deleteAll();
	}

	@Override
	public List<TypeOfMedicine> findAllTypeMedicines() {
		return (List<TypeOfMedicine>) typeMedicineRepository.findAll();
	}

	@Override
	public boolean isTypeMedicineExist(TypeOfMedicine typeMedicine) {
		// TODO Auto-generated method stub
		return false;
	}

}

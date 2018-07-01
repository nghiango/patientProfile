package eiu.edu.final_project.controller;

import java.util.List;
import java.util.Optional;

import eiu.edu.final_project.domain.TypeOfMedicine;
import eiu.edu.final_project.repository.ITypeMedicineRepository;
import eiu.edu.final_project.service.TypeMedicineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class TypeMedicineController {
	
	@Autowired
	TypeMedicineServiceImpl typeMedicineService;

	//--------------------Select All TypeMedicine-----------------------------------------
	
	@RequestMapping(value="/typeMedicine", method = RequestMethod.GET)
	public List<TypeOfMedicine> getListMedicine(){
		List<TypeOfMedicine> typeMedicines = typeMedicineService.findAllTypeMedicines();
		return typeMedicines;
	}
	
	//--------------------Select One TypeMedicine-----------------------------------------
	@RequestMapping(value="/typeMedicine/{id}", method = RequestMethod.GET)
	public TypeOfMedicine getMedicineById(@PathVariable("id") String id){
		TypeOfMedicine typeMedicine = typeMedicineService.findById(id);
		return typeMedicine;
	}
	//-------------------Create Type Medicine----------------------------------------------
	
		@RequestMapping(value="/typeMedicine", method = RequestMethod.POST)
		public TypeOfMedicine createTypeMedicine(@RequestBody TypeOfMedicine typeMedicine){
			if(!typeMedicineService.isTypeMedicineExist(typeMedicine)){
				typeMedicineService.saveTypeMedicine(typeMedicine);
			}
			return new TypeOfMedicine();
		}
		
		//------------------Update Type Medicine-----------------------------------------------
		
		@RequestMapping(value="/typeMedicine/{id}", method = RequestMethod.PUT)
		public TypeOfMedicine updateMedicine(@PathVariable("id") String id,@RequestBody TypeOfMedicine typeMedicine) {
			TypeOfMedicine currentTypeOfMedicine = typeMedicineService.findById(id);
			if (typeMedicineService.isTypeMedicineExist(currentTypeOfMedicine)) {
				typeMedicineService.updateTypeMedicine(typeMedicine);
			}
			return null;
		}
		
		//------------------Delete a Type Medicinhe-----------------------------------------
		@RequestMapping(value="/typeMedicine/{id}", method = RequestMethod.DELETE)
		public void deleteTypeMedicine(@PathVariable("id") String id){
			typeMedicineService.deleteTypeMedicineById(id);
		}
		
		//------------------Delete All Type Medicine---------------------------------------
		@RequestMapping(value="/typeMedicine", method = RequestMethod.DELETE)
		public void deleteAllTypeMedicine(){
			typeMedicineService.deleteAllTypeMedicines();
		}
}

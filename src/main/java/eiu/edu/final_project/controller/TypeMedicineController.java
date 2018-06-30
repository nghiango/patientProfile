package eiu.edu.final_project.controller;

import java.util.List;
import java.util.Optional;

import eiu.edu.final_project.domain.TypeOfMedicine;
import eiu.edu.final_project.repository.ITypeMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import javax.swing.text.html.Option;

@Controller
public class TypeMedicineController {
	
	@Autowired
	ITypeMedicineRepository typeMedicineRepository;

	//--------------------Select All TypeMedicine-----------------------------------------
	
	@RequestMapping(value="/typeMedicine", method = RequestMethod.GET)
	public List<TypeOfMedicine> getListMedicine(){
		List<TypeOfMedicine> typeMedicines = typeMedicineRepository.findAll();
		return typeMedicines;
	}
	
	//--------------------Select One TypeMedicine-----------------------------------------
	@RequestMapping(value="/typeMedicine/{id}", method = RequestMethod.GET)
	public TypeOfMedicine getMedicineById(@PathVariable("id") String id){
		Optional<TypeOfMedicine> typeMedicine = typeMedicineRepository.findById(id);
		if (typeMedicine.isPresent()) {
			return typeMedicine.get();
		}
		return new TypeOfMedicine();
	}
	//-------------------Create Type Medicine----------------------------------------------
	
		@RequestMapping(value="/typeMedicine", method = RequestMethod.POST)
		public TypeOfMedicine createTypeMedicine(@RequestBody TypeOfMedicine typeMedicine){
			if(!typeMedicineRepository.isTypeMedicineExist(typeMedicine)){
				return typeMedicineRepository.save(typeMedicine);
			}
			return new TypeOfMedicine();
		}
		
		//------------------Update Type Medicine-----------------------------------------------
		
		@RequestMapping(value="/typeMedicine/{id}", method = RequestMethod.PUT)
		public TypeOfMedicine updateMedicine(@PathVariable("id") String id,@RequestBody TypeOfMedicine typeMedicine) {
			Optional<TypeOfMedicine> currentTypeOfMedicine = typeMedicineRepository.findById(id);
			if (typeMedicineRepository.isTypeMedicineExist(currentTypeOfMedicine.get())) {
				return typeMedicineRepository.save(typeMedicine);
			}
			return null;
		}
		
		//------------------Delete a Type Medicinhe-----------------------------------------
		@RequestMapping(value="/typeMedicine/{id}", method = RequestMethod.DELETE)
		public void deleteTypeMedicine(@PathVariable("id") String id){
			typeMedicineRepository.delete(id);
		}
		
		//------------------Delete All Type Medicine---------------------------------------
		@RequestMapping(value="/typeMedicine", method = RequestMethod.DELETE)
		public void deleteAllTypeMedicine(){
			typeMedicineRepository.deleteAll();
		}
}

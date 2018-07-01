package eiu.edu.final_project.controller;

import eiu.edu.final_project.domain.Medicine;
import eiu.edu.final_project.service.MedicineServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedicineController {

    @Autowired
    MedicineServiceImpl medicineService;

    public static final Logger logger = LoggerFactory.getLogger(MedicineController.class);

    @RequestMapping(value = "/medicine")
    public List<Medicine> medicineList() {
        return medicineService.findAllMedicine();
    }

    @RequestMapping(value="/medicinebytype/{medicineTypeId}", method = RequestMethod.GET)
    public List<Medicine> getMedicineByMedicineType(@PathVariable String medicineTypeId){
        return medicineService.findAllMedicineByType(medicineTypeId);
    }

    @RequestMapping(value="/medicine/{id}", method = RequestMethod.GET)
    public Medicine getMedicine(@PathVariable String id){
        logger.info("Fetching Medicine with id {}", id);
        Medicine medicine = medicineService.findMedicinById(id);
        return medicine;
    }

    @RequestMapping(value="/medicine", method= RequestMethod.POST)
    public void createMedicine(@RequestBody Medicine medicine){
        if(medicineService.isMedicineExist(medicine)){
            logger.error("Unable to create. A Medicine with name {} already exist", medicine.getName());
        }else {
            medicineService.saveMedicine(medicine);
        }
    }

    //------------------Update Medicine-----------------------------------------------

    @RequestMapping(value="/medicine/{id}", method = RequestMethod.PUT)
    public void updateMedicine(@PathVariable String id,@RequestBody Medicine currentMedicine){
        medicineService.updateMedicine(id, currentMedicine);
    }

    //------------------Delete a Medicinhe-----------------------------------------
    @RequestMapping(value="/medicine/{id}", method = RequestMethod.DELETE)
    public void deleteMedicine(@PathVariable String id){
        Medicine medicine = medicineService.findMedicinById(id);
        medicineService.deleteMedicineById(id);
    }

    //------------------Delete All Medicine---------------------------------------
    @RequestMapping(value="/medicine", method = RequestMethod.DELETE)
    public void deleteAllMedicine(){
        medicineService.deleteAllMedicines();
    }
}

package eiu.edu.final_project.domain;



import eiu.edu.final_project.service.MedicineServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicineTest {

    @Autowired
    MedicineServiceImpl medicineService;

    @Test
    public void updateMedicine(){
        medicineService.deleteAllMedicines();
        Medicine medicine = new Medicine();
        medicine.setName("Paradon");
        medicine = medicineService.saveMedicine(medicine);
        Medicine medicine1 = new Medicine();
        medicine1.setName("Ahihi");
        medicineService.updateMedicine(medicine.getId(), medicine1);
    }

}
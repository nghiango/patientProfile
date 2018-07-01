package eiu.edu.final_project.domain;

import eiu.edu.final_project.domain.Patient;
import eiu.edu.final_project.repository.IPatientRepository;
import eiu.edu.final_project.service.PatientServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientTest {
    @Autowired
    IPatientRepository patientRepository;
    @Autowired
    PatientServiceImpl patientService;

    @Test
    public void getFullName() {
        patientRepository.deleteAll();
        Patient patient = new Patient();
        patient.setFullName("Hello");
        patientRepository.save(patient);
        Optional<Patient> patient1 = patientRepository.findByFullName("Hello");
        assertTrue(patient1.get().getFullName().equalsIgnoreCase(patient.getFullName()));
    }

    @Test
    public void updateRepository(){
        Patient patient = new Patient();
        patient.setFullName("ABC");
    }
}
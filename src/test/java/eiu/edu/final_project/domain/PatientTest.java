package eiu.edu.final_project.domain;

import eiu.edu.final_project.domain.Patient;
import eiu.edu.final_project.repository.IPatientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientTest {

    @Autowired
    IPatientRepository patientRepository;

    @Test
    public void getFullName() {
        Patient patient = new Patient();
        patient.setFullName("Hello");
        patientRepository.save(patient);
        Patient patient1 = patientRepository.findByFullName("Hello");
    }
}
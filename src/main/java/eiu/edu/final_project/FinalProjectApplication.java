package eiu.edu.final_project;

import eiu.edu.final_project.domain.Patient;
import eiu.edu.final_project.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class FinalProjectApplication implements CommandLineRunner {
    @Autowired
    private IPatientRepository iPatientRepository;

    public static void main(String[] args) {
        SpringApplication.run(FinalProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}

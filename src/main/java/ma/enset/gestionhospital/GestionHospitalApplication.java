package ma.enset.gestionhospital;
import ma.enset.gestionhospital.entities.Patient;
import ma.enset.gestionhospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.Random;

@SpringBootApplication
public class GestionHospitalApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(GestionHospitalApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        saveManualPatients();
    }

    private void saveManualPatients() {
        patientRepository.save(new Patient(null, "Emma", new Date(103, 7, 15), false, 103));
        patientRepository.save(new Patient(null, "Isabella", new Date(100, 6, 7), true, 104));
        patientRepository.save(new Patient(null, "Mia", new Date(97, 10, 29), false, 105));
        patientRepository.save(new Patient(null, "Bob", new Date(69, 4, 12), true, 106));
        patientRepository.save(new Patient(null, "John", new Date(53, 5, 26), true, 107));

    }
}



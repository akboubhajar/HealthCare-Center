package ma.hakboub.gestionhospital;
import ma.hakboub.gestionhospital.entities.Patient;
import ma.hakboub.gestionhospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

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
        savePatientIfNotExists("Emma", new Date(103, 7, 15), false, 103);
        savePatientIfNotExists("Isabella", new Date(100, 6, 7), true, 104);
        savePatientIfNotExists("Mia", new Date(97, 10, 29), false, 105);
        savePatientIfNotExists("Bob", new Date(69, 4, 12), true, 106);
        savePatientIfNotExists("John", new Date(53, 5, 26), true, 107);
    }

    private void savePatientIfNotExists(String name, Date dateOfBirth, boolean isMale, int someValue) {
        boolean patientExists = patientRepository.existsByNom(name);
        if (!patientExists) {
            patientRepository.save(new Patient(null, name, dateOfBirth, isMale, someValue));
        }
    }


}



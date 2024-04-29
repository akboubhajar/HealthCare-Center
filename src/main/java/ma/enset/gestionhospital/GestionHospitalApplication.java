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
        int numberOfPatients = 20;
        generateAndSaveRandomPatients(numberOfPatients);
    }

    private void generateAndSaveRandomPatients(int count) {
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            // Generate random patient attributes
            String name = generateRandomName();
            Date dateOfBirth = generateRandomDateOfBirth();
            boolean isInsured = random.nextBoolean();
            int bloodPressure = 100 + random.nextInt(101); // Random blood pressure value between 100 and 200

            // Save the generated patient
            patientRepository.save(new Patient(null, name, dateOfBirth, isInsured, bloodPressure));
        }
    }


    private String generateRandomName() {
        String[] names = {"John", "Alice", "Bob", "Emma", "Michael", "Sophia", "Liam", "Olivia", "Noah", "Ava", "William", "Isabella", "James", "Sophia", "Benjamin", "Charlotte", "Lucas", "Amelia", "Henry", "Mia"};
        Random random = new Random();
        return names[random.nextInt(names.length)];
    }

    private Date generateRandomDateOfBirth() {
        Random random = new Random();
        long millisIn50Years = 50L * 365 * 24 * 60 * 60 * 1000;
        long randomMillis = System.currentTimeMillis() - random.nextLong() % millisIn50Years;
        return new Date(randomMillis);
    }


}



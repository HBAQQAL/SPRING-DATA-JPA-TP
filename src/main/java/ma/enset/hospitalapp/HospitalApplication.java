package ma.enset.hospitalapp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.enset.hospitalapp.entities.Patient;
import ma.enset.hospitalapp.repository.PatientRepository;

@SpringBootApplication
public class HospitalApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null, "Hassan", new Date(), false, 4));
        patientRepository.save(new Patient(null, "Khalid", new Date(), false, 5));
        patientRepository.save(new Patient(null, "Omar", new Date(), false, 6));
        patientRepository.save(new Patient(null, "Salma", new Date(), false, 7));
    }

}

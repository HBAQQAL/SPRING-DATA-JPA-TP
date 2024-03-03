package ma.enset.hospitalapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.enset.hospitalapp.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}

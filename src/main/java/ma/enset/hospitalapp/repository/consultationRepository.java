package ma.enset.hospitalapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.enset.hospitalapp.entities.Consultation;

public interface consultationRepository extends JpaRepository<Consultation, Long> {

}

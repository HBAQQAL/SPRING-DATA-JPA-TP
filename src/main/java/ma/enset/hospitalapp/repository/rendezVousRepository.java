package ma.enset.hospitalapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.enset.hospitalapp.entities.RendezVous;

public interface rendezVousRepository extends JpaRepository<RendezVous, Long> {

}

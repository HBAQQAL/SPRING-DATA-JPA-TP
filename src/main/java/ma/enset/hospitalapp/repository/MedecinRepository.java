package ma.enset.hospitalapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.enset.hospitalapp.entities.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {

}

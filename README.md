# 📝 Rapport de TP

## 📚 Table des matières

1. [📖 Introduction](#introduction)
2. [🔧 Création de l'entité JPA Patient](#creation-entite)
3. [⚙️ Configuration de l'unité de persistance](#configuration-persistance)
4. [📚 Création de l'interface JPA Repository](#creation-repository)
5. [🧪 Test des opérations de gestion de patients](#test-gestion-patients)
6. [🔄 Migration vers MySQL](#migration-mysql)
7. [📝 Exemples avec Patient, Médecin, rendez-vous, consultation](#exemples)

## 📖 Introduction <a name="introduction"></a>

Ce rapport présente les différentes étapes de création d'une application de gestion de patients en utilisant Spring Data JPA. L'application est développée en utilisant Spring Boot et H2 comme base de données. Les étapes suivantes sont couvertes dans ce rapport :

## 🔧 Création de l'entité JPA Patient <a name="creation-entite"></a>

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nom;
  @Temporal(TemporalType.DATE)
  private Date dateNaissance;
  private boolean malade;
  private int score;
  @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
  private Collection<RendezVous> rendezVous;
}
```

## Configuration de l'unité de persistance <a name="configuration-persistance"></a>

```properties
server.port=8085
spring.h2.console.enabled=true
spring.datasource.url = jdbc:h2:mem:hospitalDB
```

## Création de l'interface JPA Repository <a name="creation-repository"></a>

```java
package ma.enset.hospitalapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.enset.hospitalapp.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}

```

## Test des opérations de gestion de patients <a name="test-gestion-patients"></a>

### Ajouter un patient

```java

// Ajouter un patient
Patient patient = new Patient();
patient.setNom("John Doe");
patient.setDateNaissance(new Date());
patient.setMalade(false);
patient.setScore(0);
patientRepository.save(patient);

```

### Consulter tous les patients

```java

// Consulter tous les patients
List<Patient> patients = patientRepository.findAll();

```

### Consulter un patient par son ID

```java

// Consulter un patient par son ID
Optional<Patient> patientOptional = patientRepository.findById(patientId);
if (patientOptional.isPresent()) {
Patient patient = patientOptional.get();
 system.out.println(patient);
} else {
 system.out.println("Patient not found");
}

```

### Chercher des patients par leur nom

```java

// Chercher des patients par leur nom
List<Patient> patients = patientRepository.findByNomContaining("John");

```

### Mettre à jour un patient

```java

// Mettre à jour un patient
Optional<Patient> patientOptional = patientRepository.findById(patientId);
if (patientOptional.isPresent()) {
Patient patient = patientOptional.get();
patient.setNom("Jane Doe");
patientRepository.save(patient);
} else {
  system.out.println("Patient not found");
  }
```

### Supprimer un patient

```java

// Supprimer un patient
patientRepository.deleteById(patientId);

```

## Migration vers MySQL <a name="migration-mysql"></a>

```properties
server.port=8085
spring.datasource.url = jdbc:mysql://localhost:3306/hospitalDB?useSSL=false&serverTimezone=UTC
spring.datasource.username = root
spring.datasource.password =
spring.jpa.hibernate.ddl-auto = update
```

## Exemples avec Patient, Médecin, rendez-vous, consultation <a name="exemples"></a>

### Création de l'entité JPA Médecin

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medecin {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nom;
  private String email;
  private String specialite;
  @OneToMany(mappedBy = "medecin", fetch = FetchType.LAZY)
  private Collection<RendezVous> rendezVous;
}

```

### Création de l'entité JPA RendezVous

```java
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RendezVous {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Date dateRDV;
  @ManyToOne
  private Patient patient;
  @ManyToOne
  private Medecin medecin;
  private StatusRDV status;
  @OneToOne(mappedBy = "rendezVous")
  private Consultation consultation;

}

```

### Création de l'entité JPA Consultation

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consultation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Date dateConsultation;
  private String rapport;
  @OneToOne
  private RendezVous rendezVous;
}

```

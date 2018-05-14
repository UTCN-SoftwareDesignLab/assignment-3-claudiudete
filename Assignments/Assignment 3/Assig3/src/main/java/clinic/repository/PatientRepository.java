package clinic.repository;

import clinic.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findAllByName(String name);
    Patient findById(long id);

    @Transactional
    @Modifying
    @Query("update Patient p set p.persNumericalCode = ?1, p.identityCardNumber= ?2, p.dateOfBirth=" +
            "?3, p.address=?4 where p.name = ?5")
    void updatePatient(String persNumericalCode, String identityCardNumber, Date dateOfBirth,String address,String name);
}

package clinic.repository;

import clinic.entity.Consultation;
import clinic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {

     Consultation findByDoctorAndDate(User doctor,Date date);
     List<Consultation> findAllById(long id);

     @Transactional
     @Modifying
     @Query("update Consultation c set c.description = ?1 where c.id = ?2")
     void updateMessage(String description,Long id);
     void deleteById(long id);
}

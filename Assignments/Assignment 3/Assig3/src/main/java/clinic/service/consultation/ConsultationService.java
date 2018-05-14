package clinic.service.consultation;

import clinic.dto.ConsultationDto;
import clinic.entity.Consultation;
import clinic.entity.User;

import java.util.Date;
import java.util.List;

public interface ConsultationService {

    void addConsultation(ConsultationDto consultationDto);
    List<Consultation> findAll();
    Consultation findByDoctorAndDate(User doctor, Date date);
    void updateMessage(long id,String description);
    List<Consultation> findById(long id);
    void removeById(long id);
}

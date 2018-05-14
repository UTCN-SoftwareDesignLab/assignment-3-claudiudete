package clinic.service.consultation;

import clinic.mapper.ConsultationMapper;
import clinic.dto.ConsultationDto;
import clinic.entity.Consultation;
import clinic.entity.User;
import clinic.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ConsultationServiceImpl implements ConsultationService {

    private ConsultationRepository consultationRepository;
    private ConsultationMapper consultationMapper;


    @Autowired
    public ConsultationServiceImpl(ConsultationRepository consultationRepository)
    {
        this.consultationRepository=consultationRepository;
        this.consultationMapper=new ConsultationMapper();
    }



    public void addConsultation(ConsultationDto consultationDto)
    {
        Consultation consultation=consultationMapper.mapFrom(consultationDto);
        consultationRepository.save(consultation);
    }

    public List<Consultation> findAll()
    {
        return consultationRepository.findAll();
    }

    public Consultation findByDoctorAndDate(User doctor,Date date)
    {
        return consultationRepository.findByDoctorAndDate(doctor,date);
    }


    public void updateMessage(long id,String description)
    {
        consultationRepository.updateMessage(description,id);
    }

    public List<Consultation> findById(long id)
    {
        return consultationRepository.findAllById(id);
    }

    public void removeById(long id)
    {
        consultationRepository.deleteById(id);
    }







}

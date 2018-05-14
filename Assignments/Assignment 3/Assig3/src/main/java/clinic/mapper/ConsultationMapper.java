package clinic.mapper;

import clinic.dto.ConsultationDto;
import clinic.entity.Consultation;

public class ConsultationMapper {
    private PatientMapper patientMapper=new PatientMapper();



    public ConsultationDto mapTo(Consultation consultation)
    {

        return new ConsultationDto(consultation.getDate(),consultation.getPatient(),consultation.getDoctor());
    }

    public Consultation mapFrom(ConsultationDto consultationDto)
    {
        return new Consultation(consultationDto.getDate(),consultationDto.getPatient(),consultationDto.getDoctor());
    }
}

package clinic.mapper;

import clinic.dto.PatientDto;
import clinic.entity.Patient;

public class PatientMapper {

    public PatientDto mapTo(Patient patient)
    {
        PatientDto patientDto=new PatientDto(
                patient.getName(),
                patient.getPersNumericalCode(),
                patient.getIdentityCardNumber(),
                patient.getAddress(),
                patient.getDateofBirth());
        return patientDto;
    }

    public Patient mapFrom(PatientDto patientDto)
    {
        Patient p=new Patient(patientDto.getName(),
                patientDto.getPersNumericalCode(),
                patientDto.getIdentityCardNumber(),
                patientDto.getDateOfBirth(),
                patientDto.getAddress());
        return p;
    }
}

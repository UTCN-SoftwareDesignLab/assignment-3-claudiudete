package clinic.service.Patient;

import clinic.dto.PatientDto;
import clinic.entity.Patient;

import java.util.List;

public interface PatientService {


    void savePatient(PatientDto patientDto);
    List<PatientDto> findAll();
    boolean updatePatient(PatientDto patientDto);
    List<PatientDto> findAllByName(String name);
    List<Patient> find();
    Patient findById(long id);
}

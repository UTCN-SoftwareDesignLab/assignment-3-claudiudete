package clinic.service.Patient;


import clinic.mapper.PatientMapper;
import clinic.dto.PatientDto;
import clinic.entity.Patient;
import clinic.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;
    private PatientMapper patientMapper;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository)
    {

        this.patientRepository=patientRepository;
        this.patientMapper=new PatientMapper();
    }


    public void savePatient(PatientDto patientDto)
    {
        patientRepository.save(new Patient(patientDto.getName(),patientDto.getPersNumericalCode(),patientDto.getIdentityCardNumber(),patientDto.getDateOfBirth()
        ,patientDto.getAddress()));
    }

    public List<PatientDto> findAll()
    {
        List<Patient> patients = patientRepository.findAll();
        List<PatientDto> pat=new ArrayList<PatientDto>();
        for(Patient p:patients)
        {
            PatientDto patient=patientMapper.mapTo(p);
            pat.add(patient);
        }
        return pat;
    }

    public boolean updatePatient(PatientDto patientDto)
    {
      List<Patient> patients=patientRepository.findAllByName(patientDto.getName());
      if(patients.size()==0) return false;
      else
      {
          patientRepository.updatePatient(patientDto.getPersNumericalCode(),patientDto.getIdentityCardNumber(),patientDto.getDateOfBirth(),
                  patientDto.getAddress(),patientDto.getName());
          return true;
      }
    }

    public List<PatientDto> findAllByName(String name)
    {

       List<Patient> patients= patientRepository.findAllByName(name);
       List<PatientDto> patientsDto=new ArrayList<PatientDto>();
       for(Patient p:patients)
       {
            patientsDto.add(patientMapper.mapTo(p));
       }

       return patientsDto;
    }

    public List<Patient> find()
    {
        return patientRepository.findAll();
    }

    public Patient findById(long id)
    {
        return patientRepository.findById(id);
    }


}

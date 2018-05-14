package clinic.dto;

import clinic.entity.Patient;
import clinic.entity.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class ConsultationDto {

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "You can't make a consultation in the past")
    private Date date;


   @NotNull(message="Please enter a patient")
    private Patient patient;

   @NotNull(message="Please enter a doctor")
    private User doctor;

    private String description;

    public ConsultationDto(@NotNull @Future(message = "You can't make a consultation in the past") Date date, @NotNull(message = "Please enter a patient") Patient patient, @NotNull(message = "Please enter a doctor") User doctor) {
        this.date = date;
        this.patient = patient;
        this.doctor = doctor;
    }

    public ConsultationDto()
    {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }
}

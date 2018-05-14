package clinic.webSocket;

import java.util.Date;


public class OutNotification
{
    private String patientName;
    private String doctorUsername;
    private String dateOfConsultation;

    public OutNotification() {}

    public OutNotification(String patientName, String doctorUsername, String dateOfConsultation) {
        this.patientName = patientName;
        this.doctorUsername = doctorUsername;
        this.dateOfConsultation = dateOfConsultation;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorUsername() {
        return doctorUsername;
    }

    public void setDoctorName(String doctorUsername) {
        this.doctorUsername = doctorUsername;
    }

    public String getDateOfConsultation() {
        return dateOfConsultation;
    }

    public void setDateOfConsultation(String dateOfConsultation) {
        this.dateOfConsultation = dateOfConsultation;
    }
}
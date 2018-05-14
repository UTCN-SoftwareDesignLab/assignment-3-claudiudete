package clinic.webSocket;



public class Notification {

    private String patientId;
    private String doctorId;
    private String dateOfConsultation;

    public Notification() {

    }

    public Notification(String patientId, String doctorId, String dateOfConsultation) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.dateOfConsultation = dateOfConsultation;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDateOfConsultation() {
        return dateOfConsultation;
    }

    public void setDateOfConsultation(String dateOfConsultation) {
        this.dateOfConsultation = dateOfConsultation;
    }
}



package clinic.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String name;

    @Column(unique=true)
    private String persNumericalCode;

    private String identityCardNumber;

    private Date dateOfBirth;
    private String address;

    public Patient()
    {

    }

    public Patient(String name, String persNumericalCode, String identityCardNumber, Date dateOfBirth, String address) {
        this.name = name;
        this.persNumericalCode = persNumericalCode;
        this.identityCardNumber = identityCardNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersNumericalCode() {
        return persNumericalCode;
    }

    public void setPersNumericalCode(String persNumericalCode) {
        this.persNumericalCode = persNumericalCode;
    }

    public String getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(String identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public Date getDateofBirth() {
        return dateOfBirth;
    }

    public void setDateofBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String toString()
    {
        return this.name;
    }
}

package clinic.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class PatientDto {



    @NotNull
    private String name;

    @Size(min=11,max=11,message="Personal numerical code must be of length 11")
    private String persNumericalCode;

    @Size(min=5,max=7,message="Must be between 5 and 7 characters long")
    private String identityCardNumber;

    @NotNull
    private String address;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    public PatientDto(@NotNull String name, @Size(min = 11, max = 11, message = "Personal numerical code must be of length 11") String persNumericalCode, @Size(min = 5, max = 7, message = "Must be between 5 and 7 characters long") String identityCardNumber, @NotNull String address, @NotNull Date dateOfBirth) {
        this.name = name;
        this.persNumericalCode = persNumericalCode;
        this.identityCardNumber = identityCardNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }



    public PatientDto()
    {

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


}

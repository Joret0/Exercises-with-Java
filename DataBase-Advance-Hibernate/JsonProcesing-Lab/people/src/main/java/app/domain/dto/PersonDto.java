package app.domain.dto;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class PersonDto implements Serializable{
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private AddressDto address;
    @Expose
    private Set<PhoneNumberDto> phoneNumbers;

    public PersonDto() {
        this.phoneNumbers = new HashSet<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public Set<PhoneNumberDto> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<PhoneNumberDto> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s %s%nAddress: %s, %s, %s%nPhone numbers:%n",
                this.firstName, this.lastName, this.address.getCountry(), this.address.getCity(), this.address.getStreet()));
        for (PhoneNumberDto phoneNumber : this.phoneNumbers) {
            builder.append(String.format("%s%n", phoneNumber.getNumber()));
        }

        return builder.toString();
    }
}

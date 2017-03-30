package dto;

import java.util.List;

public class UserDto implements IBaseDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private List<SessionDto> sessions;

    //region GetSet

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

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public List<SessionDto> getSessions() {
        return sessions;
    }
    public void setSessions(List<SessionDto> sessions) {
        this.sessions = sessions;
    }

    //endregion
}
package dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

//@Named(value = "userDto")
//@ManagedBean
//@RequestScoped
public class UserDto implements IBaseDto {

    @NotNull
    @Size(min = 1)
    private String email;

    @NotNull
    @Size(min = 1)
    private String firstName;

    @NotNull
    @Size(min = 1)
    private String lastName;

    @NotNull
    @Size(min = 1)
    private String phoneNumber;

    @NotNull
    @Size(min = 1)
    private String password;

    @NotNull
    @Size(min = 1)
    private String role;
    private List<SessionDto> sessions;

    public UserDto() {
//        email = "";
//        firstName = "";
//        lastName = "";
//        phoneNumber = "";
//        password = "";
//        sessions = new ArrayList<>();
        this.role = "user";
    }

    public UserDto(String email, String firstName, String lastName, String phoneNumber, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = "user";
    }

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

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public List<SessionDto> getSessions() {
        return sessions;
    }
    public void setSessions(List<SessionDto> sessions) {
        this.sessions = sessions;
    }

    //endregion
}
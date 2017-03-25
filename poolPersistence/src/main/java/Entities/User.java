package Entities;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements IBaseEntity {

    @Id
    @Column(name = "email", length = 100)
    private String email;
    @Basic
    @NotNull
    @Column(name = "first_name", length = 100)
    private String firstName;
    @Basic
    @NotNull
    @Column(name = "last_name", length = 100)
    private String lastName;
    @Basic
    @NotNull
    @Column(name = "phone_number", length = 100)
    private String phoneNumber;

    @OneToMany(mappedBy = "user")
    private List<Session> sessionsList;
    @Basic
    @NotNull
    @Column(name = "password")
    private String password;

    //region getAndSet

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

    public List<Session> getSessionsList() {
        return sessionsList;
    }
    public void setSessionsList(List<Session> sessionsList) {
        this.sessionsList = sessionsList;
    }

    //endregion
}

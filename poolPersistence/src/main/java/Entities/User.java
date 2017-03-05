package Entities;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id")
    @NotNull
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int userId;
    @Basic
    @Column(name = "first_name", nullable = false, length = 120)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = false, length = 120)
    private String lastName;
    @Basic
    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;
    @Basic
    @Column(name = "email", length = 50)
    private String email;
    @OneToMany(mappedBy = "user")
    private Collection<Session> sessionsByUserId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    //region getAndSet

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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



    public Collection<Session> getSessionsByUserId() {
        return sessionsByUserId;
    }

    public void setSessionsByUserId(Collection<Session> sessionsByUserId) {
        this.sessionsByUserId = sessionsByUserId;
    }

    //endregion


}
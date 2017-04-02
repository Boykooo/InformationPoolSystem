package Entities;

import javax.validation.constraints.NotNull;
import javax.persistence.*;

@Entity
@Table(name = "admin", schema = "ips")
public class Admin {

    @Id
    @Column(name = "username")
    private String username;

    @Basic
    @NotNull
    @Column(name = "password")
    private String password;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}

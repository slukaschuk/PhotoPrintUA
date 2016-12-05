package ua.com.spiritus.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="user")
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    private String login;
    private String firtsName;
    private String lastName;
    private String password;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }


     public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirtsname() {
        return firtsName;
    }

    public void setFirtsname(String firtsname) {
        this.firtsName = firtsname;
    }

    public String getLastsname() {
        return lastName;
    }

    public void setLastsname(String lastsname) {
        this.lastName = lastsname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!userId.equals(user.userId)) return false;
        if (!login.equals(user.login)) return false;
        if (firtsName != null ? !firtsName.equals(user.firtsName) : user.firtsName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        return password.equals(user.password);

    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + (firtsName != null ? firtsName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", firtsname='" + firtsName + '\'' +
                ", lastsname='" + lastName + '\'' +
                '}';
    }
}

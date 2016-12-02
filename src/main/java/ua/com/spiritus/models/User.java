package ua.com.spiritus.models;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String login;
    private String password;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer userId) {
        this.Id = Id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    protected User(){}

    public User(Integer id) {
        this.Id = id;
    }
    public User(String login, String pass) {
        this.login = login;
        this.password = pass;
    }

}

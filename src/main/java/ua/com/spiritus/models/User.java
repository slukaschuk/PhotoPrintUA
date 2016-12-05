package ua.com.spiritus.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String login;
    private String firtsname;
    private String lastsname;
    private String password;


}

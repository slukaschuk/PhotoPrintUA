package ua.com.spiritus.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Setter
@Getter
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "login", unique = true, length = 200)
    @NotBlank
    @Email
    private String login;
    @Column(name = "first_name", length = 100)
    private String firtsName;
    @Column(name = "last_name", length = 100)
    private String lastName;
    @Column(name = "password", length = 200)
    private String password;


}

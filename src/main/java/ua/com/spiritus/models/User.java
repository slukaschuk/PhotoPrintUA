package ua.com.spiritus.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.userdetails.UserDetails;
import ua.com.spiritus.enums.Role;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "login", unique = true, length = 200)
    @NotBlank
   // @Email
    private String login;
    @Column(name = "first_name", length = 100)
    private String firtsName;
    @Column(name = "last_name", length = 100)
    private String lastName;
    @Column(name = "password", length = 200)
    @JsonIgnore
    @NotBlank
    private String password;
    //Security
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Role> authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;


    @Override
    public String getUsername() {
        return this.login;
    }
}

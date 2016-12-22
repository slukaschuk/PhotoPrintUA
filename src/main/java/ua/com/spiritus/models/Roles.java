package ua.com.spiritus.models;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "role_name", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role roleName;

}

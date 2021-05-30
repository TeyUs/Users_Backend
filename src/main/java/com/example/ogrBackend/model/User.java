package com.example.ogrBackend.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
@ApiModel
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="firstname", nullable = false, length = 50)
    private String firstname;
    @Column(name ="lastname", nullable = false, length = 50)
    private String lastname;
    @Column(name = "user_name", nullable = false, length = 50, unique = true)
    private String userName;

    public User(String userName, String firstname, String lastname) {
        this.userName = userName;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}

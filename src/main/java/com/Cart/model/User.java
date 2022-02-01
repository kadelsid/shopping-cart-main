package com.Cart.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "user_db")
@Data
public class User {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column //(name = "First Name")
    private String firstName;

    @Column //(name = "Last Name")
    private String lastName;

    @Column //(name = "Email")
    private String email;

    @Column
    private String password;

}

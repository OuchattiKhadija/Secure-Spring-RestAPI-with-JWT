package com.demosecureapi.demosecureapi.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String userName;

    @NotNull
    @NotEmpty
    @Column
    private String password;

    @ManyToOne
    private Role role;
}

package com.example.msaccountreservation.entity;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Table(name = "account_status")
@Setter
public class AccountStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Column(length = 255)
    private String description;

}
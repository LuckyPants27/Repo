package com.example.msaccountreservation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "client")
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "citizenship", length = 100)
    private String citizenship;

    @Column(name = "client_type", length = 50)
    private String clientType;

    @Column(name = "document_number", length = 50)
    private String documentNumber;

    @Column(name = "document_series", length = 20)
    private String documentSeries;

    @Column(name = "document_type", length = 50)
    private String documentType;

    @Column(name = "mdm_code")
    private Long mdmCode;
}
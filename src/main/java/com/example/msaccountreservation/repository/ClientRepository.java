package com.example.msaccountreservation.repository;

import com.example.msaccountreservation.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
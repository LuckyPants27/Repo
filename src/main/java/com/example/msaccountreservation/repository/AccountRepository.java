package com.example.msaccountreservation.repository;

import com.example.msaccountreservation.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}
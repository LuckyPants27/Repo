package com.example.msaccountreservation.repository;

import com.example.msaccountreservation.entity.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountStatusRepository extends JpaRepository<AccountStatus, Integer> {
    Optional<AccountStatus> findByName(String name);
    boolean existsByName(String name);
}
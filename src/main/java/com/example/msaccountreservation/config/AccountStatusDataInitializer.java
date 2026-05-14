package com.example.msaccountreservation.config;

import com.example.msaccountreservation.entity.AccountStatus;
import com.example.msaccountreservation.repository.AccountStatusRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class AccountStatusDataInitializer implements ApplicationRunner {

    private static final List<AccountStatus> REFERENCE_STATUSES = List.of(
            new AccountStatus("NEW",         "Счёт создан в БД"),
            new AccountStatus("IN_CREATION", "Запрос на создание счёта был отправлен"),
            new AccountStatus("CREATED",     "Счёт создан"),
            new AccountStatus("CANCELLED",   "Счёт аннулирован"),
            new AccountStatus("CLOSED",      "Счёт закрыт")
    );

    private final AccountStatusRepository accountStatusRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) {
        log.info("Initializing account_status reference data...");

        int count = 0;
        for (AccountStatus status : REFERENCE_STATUSES) {
            if (!accountStatusRepository.existsByName(status.getName())) {
                accountStatusRepository.save(status);
                count++;
            }
        }

        if (count == 0) {
            log.info("account status is up to date, nothing to insert.");
        } else {
            log.info("Inserted {} new account status(es).", count);
        }
    }
}
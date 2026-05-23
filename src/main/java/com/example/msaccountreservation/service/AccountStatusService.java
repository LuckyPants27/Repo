package com.example.msaccountreservation.service;

import com.example.msaccountreservation.entity.AccountStatus;
import com.example.msaccountreservation.entity.AccountStatusEnum;
import com.example.msaccountreservation.repository.AccountStatusRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@ConditionalOnProperty(value = "app.account-status-init.enabled", havingValue = "true")
public class AccountStatusService {

    private final AccountStatusRepository accountStatusRepository;

    @PostConstruct
    @Transactional
    public void init() {
        log.info("Initializing account_status reference data...");

        int count = 0;
        for (AccountStatusEnum statusEnum : AccountStatusEnum.values()) {
            if (!accountStatusRepository.existsByName(statusEnum.name())) {
                AccountStatus status = new AccountStatus();
                status.setName(statusEnum.name());
                accountStatusRepository.save(status);
                count++;
            }
        }

        if (count == 0) {
            log.info("account_status is up-to-date, nothing to insert.");
        } else {
            log.info("Inserted {} new account status(es).", count);
        }
    }
}
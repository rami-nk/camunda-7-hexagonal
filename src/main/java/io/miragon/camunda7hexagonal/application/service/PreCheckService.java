package io.miragon.camunda7hexagonal.application.service;

import io.miragon.camunda7hexagonal.application.port.in.PreCheckCommand;
import io.miragon.camunda7hexagonal.application.port.in.PreCheckUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PreCheckService implements PreCheckUseCase {

    @Override
    public void preCheck(PreCheckCommand preCheckCommand) {
        log.info("Checking credit request for {} {} with age {} and income {}",
                preCheckCommand.getFirstname(),
                preCheckCommand.getLastname(),
                preCheckCommand.getAge(),
                preCheckCommand.getIncome()
        );
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
package io.miragon.hexagonal.application.service;

import io.miragon.hexagonal.application.port.in.checkbookavailablity.CheckBookAvailabilityCommand;
import io.miragon.hexagonal.application.port.in.checkbookavailablity.CheckBookAvailabilityResult;
import io.miragon.hexagonal.application.port.in.checkbookavailablity.CheckBookAvailabilityUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
class CheckBookAvailabilityService implements CheckBookAvailabilityUseCase {

    @Override
    public CheckBookAvailabilityResult checkAvailability(CheckBookAvailabilityCommand checkBookAvailabilityCommand) {
        log.info("Checking book availability for {} {} with isbn {}",
                checkBookAvailabilityCommand.getTitle(),
                checkBookAvailabilityCommand.getAuthor(),
                checkBookAvailabilityCommand.getIsbn()
        );
        return new CheckBookAvailabilityResult(true);
    }
}
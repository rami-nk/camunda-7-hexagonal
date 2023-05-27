package io.miragon.hexagonal.application.port.in.checkbookavailablity;

public interface CheckBookAvailabilityUseCase {

    CheckBookAvailabilityResult checkAvailability(CheckBookAvailabilityCommand checkBookAvailabilityCommand);
}
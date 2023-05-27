package io.miragon.hexagonal.application.service;

import io.miragon.hexagonal.application.port.in.prepareshipment.PrepareShipmentCommand;
import io.miragon.hexagonal.application.port.in.prepareshipment.PrepareShipmentUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrepareShipmentService implements PrepareShipmentUseCase {

    @Override
    public void prepareShipment(PrepareShipmentCommand prepareShipmentCommand) {
        log.info("Preparing shipment for {} {} with address {}",
                prepareShipmentCommand.getFirstname(),
                prepareShipmentCommand.getLastname(),
                prepareShipmentCommand.getAddress());
    }
}

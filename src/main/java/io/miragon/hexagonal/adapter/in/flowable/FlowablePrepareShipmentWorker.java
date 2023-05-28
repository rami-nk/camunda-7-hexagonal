package io.miragon.hexagonal.adapter.in.flowable;

import io.miragon.hexagonal.application.port.in.prepareshipment.PrepareShipmentCommand;
import io.miragon.hexagonal.application.port.in.prepareshipment.PrepareShipmentUseCase;
import lombok.AllArgsConstructor;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("prepareShipmentWorker")
@AllArgsConstructor
public class FlowablePrepareShipmentWorker implements JavaDelegate {

    private final PrepareShipmentUseCase prepareShipmentUseCase;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        var command = new PrepareShipmentCommand();
        command.setFirstname((String) delegateExecution.getVariable("firstname"));
        command.setLastname((String) delegateExecution.getVariable("lastname"));
        command.setAddress((String) delegateExecution.getVariable("address"));
        prepareShipmentUseCase.prepareShipment(command);
    }
}
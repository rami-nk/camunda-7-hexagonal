package io.miragon.hexagonal.adapter.out.flowable;

import io.miragon.hexagonal.application.port.out.CustomerMessageOutCommand;
import io.miragon.hexagonal.application.port.out.CustomerMessagePort;
import lombok.AllArgsConstructor;
import org.flowable.engine.RuntimeService;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@AllArgsConstructor
public class FlowableCustomerMessageAdapter implements CustomerMessagePort {

    private final RuntimeService runtimeService;

    @Override
    public void deliverCustomerMessage(CustomerMessageOutCommand customerMessageOutCommand) {
        Map<String, Object> map = Map.of(
                "firstname", customerMessageOutCommand.getFirstname(),
                "lastname", customerMessageOutCommand.getLastname(),
                "address", customerMessageOutCommand.getAddress()
        );

        // get the first execution with the message event subscription
        var executions = runtimeService.createExecutionQuery()
                .messageEventSubscriptionName("BookRequestConfirmation")
                .list();

        if (executions.isEmpty()) {
            throw new RuntimeException("No executions found");
        }

        var executionId = executions.get(0).getId();

        runtimeService.messageEventReceived("BookRequestConfirmation", executionId, map);
    }
}
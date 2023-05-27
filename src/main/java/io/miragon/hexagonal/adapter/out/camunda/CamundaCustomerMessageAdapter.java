package io.miragon.hexagonal.adapter.out.camunda;

import io.miragon.hexagonal.application.port.out.CustomerMessageOutCommand;
import io.miragon.hexagonal.application.port.out.CustomerMessagePort;
import lombok.AllArgsConstructor;
import org.camunda.community.rest.client.api.MessageApi;
import org.camunda.community.rest.client.dto.CorrelationMessageDto;
import org.camunda.community.rest.client.dto.VariableValueDto;
import org.camunda.community.rest.client.invoker.ApiException;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@AllArgsConstructor
public class CamundaCustomerMessageAdapter implements CustomerMessagePort {

    private final MessageApi messageApi;

    @Override
    public void deliverCustomerMessage(CustomerMessageOutCommand customerMessageOutCommand) {
        var correlationMessageDto = new CorrelationMessageDto();
        correlationMessageDto.setMessageName("BookRequestConfirmation");

        var variables = new HashMap<String, VariableValueDto>();
        var variableValueDto = new VariableValueDto();
        variableValueDto.setValue(customerMessageOutCommand);

        correlationMessageDto.setProcessVariables(variables);
        try {
            messageApi.deliverMessage(correlationMessageDto);
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }
}

package io.miragon.camunda7hexagonal.adapter.in;

import io.miragon.camunda7hexagonal.application.port.in.PreCheckCommand;
import io.miragon.camunda7hexagonal.application.port.in.PreCheckUseCase;
import org.camunda.bpm.client.ExternalTaskClient;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PreCheckWorkerAdapter extends CamundaAdapter {

    private final PreCheckUseCase preCheckUseCase;

    protected PreCheckWorkerAdapter(ExternalTaskClient externalTaskClient, CamundaDataMapper camundaDataMapper, PreCheckUseCase preCheckUseCase) {
        super(externalTaskClient, camundaDataMapper);
        this.preCheckUseCase = preCheckUseCase;
    }

    @Override
    public void execute(Map<String, Object> data) {
        final PreCheckCommand preCheckCommand = (PreCheckCommand) mapInput(PreCheckCommand.class, data);
        preCheckUseCase.preCheck(preCheckCommand);
    }

    @Override
    public String subscriptionTopic() {
        return "preCheck";
    }
}
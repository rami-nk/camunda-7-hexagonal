package io.miragon.camunda7hexagonal.adapter.in;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.camunda.bpm.client.ExternalTaskClient;

import java.util.Map;

public abstract class CamundaAdapter {

    private final ExternalTaskClient externalTaskClient;
    private final CamundaDataMapper camundaDataMapper;

    protected CamundaAdapter(ExternalTaskClient externalTaskClient, CamundaDataMapper camundaDataMapper) {
        this.externalTaskClient = externalTaskClient;
        this.camundaDataMapper = camundaDataMapper;
    }

    public abstract void execute(Map<String, Object> data);

    public abstract String subscriptionTopic();

    @PostConstruct
    public void _subscribe() {
        externalTaskClient.subscribe(subscriptionTopic())
                .lockDuration(1000)
                .handler((externalTask, externalTaskService) -> {

                    // map engine data to PreCheckCommand object
                    final Map<String, Object> data = camundaDataMapper.mapFromEngineData(externalTask.getAllVariablesTyped());

                    // execute use case
                    execute(data);

                    // complete task
                    externalTaskService.complete(externalTask);
                })
                .open();
    }

    protected Object mapInput(final Class<?> inputType, final Object object) {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.convertValue(object, inputType);
    }
}
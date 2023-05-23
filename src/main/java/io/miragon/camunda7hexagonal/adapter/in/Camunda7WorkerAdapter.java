package io.miragon.camunda7hexagonal.adapter.in;

import io.miragon.camunda7hexagonal.adapter.in.worker.ExternalTaskHandler;
import lombok.AllArgsConstructor;
import org.camunda.bpm.client.ExternalTaskClient;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@AllArgsConstructor
public class Camunda7WorkerAdapter implements ExternalWorker {

    private final ExternalTaskClient client;

    private final CamundaDataMapper camundaDataMapper;

    @Override
    public void subscribe(ExternalTaskHandler handler) {
        client.subscribe(handler.getTopic())
                .lockDuration(1000)
                .handler((externalTask, externalTaskService) -> {
                    // map from engine data
                    final Map<String, Object> data = camundaDataMapper.mapFromEngineData(externalTask.getAllVariablesTyped());

                    // execute handler
                    handler.execute(data);

                    // complete task
                    externalTaskService.complete(externalTask);
                })
                .open();
    }
}
package io.miragon.hexagonal.adapter.out;

import io.miragon.hexagonal.adapter.in.worker.ExternalTaskHandler;
import io.miragon.hexagonal.adapter.in.ExternalWorker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@AllArgsConstructor
public class ExternalWorkerSubscriber {

    private final List<ExternalTaskHandler> externalTaskHandlers;

    private final ExternalWorker externalWorker;

    @PostConstruct
    public void subscribe() {
        externalTaskHandlers.forEach(externalWorker::subscribe);
    }
}
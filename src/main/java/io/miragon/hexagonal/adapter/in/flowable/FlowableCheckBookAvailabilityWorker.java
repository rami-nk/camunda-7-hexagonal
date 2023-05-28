package io.miragon.hexagonal.adapter.in.flowable;

import io.miragon.hexagonal.application.port.in.checkbookavailablity.CheckBookAvailabilityCommand;
import io.miragon.hexagonal.application.port.in.checkbookavailablity.CheckBookAvailabilityUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("checkBookAvailabilityWorker")
@AllArgsConstructor
@Slf4j
public class FlowableCheckBookAvailabilityWorker implements JavaDelegate {

    private final CheckBookAvailabilityUseCase checkBookAvailabilityUseCase;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        var command = new CheckBookAvailabilityCommand();
        command.setTitle((String) delegateExecution.getVariable("title"));
        command.setAuthor((String) delegateExecution.getVariable("author"));
        command.setIsbn((String) delegateExecution.getVariable("isbn"));
        checkBookAvailabilityUseCase.checkAvailability(command);
        log.info("ProcessInstanceId: {}", delegateExecution.getProcessInstanceId());
    }
}
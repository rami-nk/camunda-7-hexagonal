package io.miragon.hexagonal.adapter.in.worker;

import io.miragon.hexagonal.adapter.in.MapToObjectMapper;
import io.miragon.hexagonal.application.port.in.PreCheckCommand;
import io.miragon.hexagonal.application.port.in.PreCheckUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@AllArgsConstructor
public class PreCheckWorkerAdapter implements ExternalTaskHandler {

    private final PreCheckUseCase preCheckUseCase;

    private final MapToObjectMapper mapper;

    @Override
    public void execute(Map<String, Object> data) {
        final PreCheckCommand preCheckCommand = mapper.map(data, PreCheckCommand.class);
        preCheckUseCase.preCheck(preCheckCommand);
    }

    @Override
    public String getTopic() {
        return "preCheck";
    }
}
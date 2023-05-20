package io.miragon.camunda7hexagonal.application.port.in;

public interface PreCheckUseCase {

    void preCheck(PreCheckCommand preCheckCommand);
}
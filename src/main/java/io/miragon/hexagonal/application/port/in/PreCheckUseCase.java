package io.miragon.hexagonal.application.port.in;

public interface PreCheckUseCase {

    void preCheck(PreCheckCommand preCheckCommand);
}
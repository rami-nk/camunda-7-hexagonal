package io.miragon.camunda7hexagonal.adapter.in;

import io.miragon.camunda7hexagonal.adapter.in.worker.ExternalTaskHandler;

public interface ExternalWorker {

    void subscribe(ExternalTaskHandler handler);
}
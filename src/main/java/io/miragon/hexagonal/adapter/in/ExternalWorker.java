package io.miragon.hexagonal.adapter.in;

import io.miragon.hexagonal.adapter.in.worker.ExternalTaskHandler;

public interface ExternalWorker {

    void subscribe(ExternalTaskHandler handler);
}
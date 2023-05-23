package io.miragon.camunda7hexagonal.adapter.in.worker;

import java.util.Map;

public interface ExternalTaskHandler {

    void execute(Map<String, Object> data);

    String getTopic();
}

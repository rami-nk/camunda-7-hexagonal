package io.miragon.hexagonal.application.port.out;

public interface CustomerMessagePort {

    void deliverCustomerMessage(CustomerMessageOutCommand customerMessageOutCommand);
}

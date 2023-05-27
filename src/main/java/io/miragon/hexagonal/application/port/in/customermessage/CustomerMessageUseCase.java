package io.miragon.hexagonal.application.port.in.customermessage;

public interface CustomerMessageUseCase {

        void sendCustomerMessage(CustomerMessageInCommand customerMessageInCommand);
}

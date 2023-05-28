package io.miragon.hexagonal.adapter.in.rest;

import io.miragon.hexagonal.application.port.in.customermessage.CustomerMessageInCommand;
import io.miragon.hexagonal.application.port.in.customermessage.CustomerMessageUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@AllArgsConstructor
public class CustomerMessageController {

    private final CustomerMessageUseCase customerMessageUseCase;

    @PostMapping("/customer-message")
    public void customerMessage(@RequestBody CustomerMessageRequestDto customerMessageRequestDto) {
        var customerMessageInCommand = new CustomerMessageInCommand();
        customerMessageInCommand.setFirstname(customerMessageRequestDto.getFirstname());
        customerMessageInCommand.setLastname(customerMessageRequestDto.getLastname());
        customerMessageInCommand.setAddress(customerMessageRequestDto.getAddress());
        customerMessageUseCase.sendCustomerMessage(customerMessageInCommand);
    }
}
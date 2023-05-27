package io.miragon.hexagonal.application.port.out;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerMessageOutCommand {

    private String firstname;

    private String lastname;

    private String address;
}

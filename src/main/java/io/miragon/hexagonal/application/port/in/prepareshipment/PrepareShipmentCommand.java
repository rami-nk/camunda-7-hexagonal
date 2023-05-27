package io.miragon.hexagonal.application.port.in.prepareshipment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrepareShipmentCommand {

    private String firstname;

    private String lastname;

    private String address;
}
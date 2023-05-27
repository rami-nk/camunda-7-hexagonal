package io.miragon.hexagonal.application.port.in.customermessage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerMessageInCommand {

    private String firstname;

    private String lastname;

    private String address;
}

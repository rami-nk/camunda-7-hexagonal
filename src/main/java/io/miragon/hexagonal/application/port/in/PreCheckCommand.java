package io.miragon.hexagonal.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PreCheckCommand {

    private String firstname;

    private String lastname;

    private int age;

    private int income;
}
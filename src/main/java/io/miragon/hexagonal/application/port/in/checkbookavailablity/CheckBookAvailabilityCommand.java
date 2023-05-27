package io.miragon.hexagonal.application.port.in.checkbookavailablity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CheckBookAvailabilityCommand {

    private String title;

    private String author;

    private String isbn;
}
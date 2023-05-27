package io.miragon.hexagonal.application.port.in.checkbookavailablity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CheckBookAvailabilityResult {

    boolean available;
}

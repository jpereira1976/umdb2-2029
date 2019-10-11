package edu.um.db2.demospringboot.primer_parcial;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Movement {
    private String accountId;
    private double amount;
}

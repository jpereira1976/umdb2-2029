package edu.um.db2.demospringboot.primer_parcial;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Transaction {
    private String id;
    private List<Movement> movements;
}

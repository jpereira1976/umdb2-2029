package edu.um.db2.demospringboot;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@Builder
@ToString
public class Factura implements Serializable {
    private static final long serialVersionUID = 6479793627050102127L;

    private Long number;
    private String cliente;
    private double total;
}

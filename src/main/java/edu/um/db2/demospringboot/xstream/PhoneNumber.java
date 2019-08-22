package edu.um.db2.demospringboot.xstream;

import lombok.Builder;
import lombok.Data;

@Data
public class PhoneNumber {
    private int code;
    private String number;


    public PhoneNumber(int code, String number) {
        this.code = code;
        this.number = number;
    }

}

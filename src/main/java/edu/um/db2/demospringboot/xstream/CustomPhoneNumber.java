package edu.um.db2.demospringboot.xstream;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CustomPhoneNumber extends PhoneNumber {
    private String myCustomProperty;

    public CustomPhoneNumber(int code, String number, String myCustomProperty) {
        super(code, number);
        this.myCustomProperty = myCustomProperty;
    }
}

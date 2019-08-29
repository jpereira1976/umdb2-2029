package edu.um.db2.demospringboot.xstream;

import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import com.thoughtworks.xstream.XStream;

public class XStreamPersonExample {

    public static void main(String[] args) {
        XStream xstream = new XStream();
        Person javier = Person.builder()
                .firstName("Javier")
                .lastName("Pereira")
                .phone(new CustomPhoneNumber(1, "094XXXXXX", "secret")
                ).build();

        xstream.alias("person", Person.class);
        xstream.alias("custom-phone", CustomPhoneNumber.class);
        String javierXML = xstream.toXML(javier);

        System.out.println(javierXML);


        Person javierClonado = (Person)xstream.fromXML(javierXML);

        System.out.println(javierClonado);


    }
}

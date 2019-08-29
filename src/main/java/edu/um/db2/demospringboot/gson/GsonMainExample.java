package edu.um.db2.demospringboot.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import edu.um.db2.demospringboot.xstream.CustomPhoneNumber;
import edu.um.db2.demospringboot.xstream.Person;
import edu.um.db2.demospringboot.xstream.PhoneNumber;

public class GsonMainExample {

    public static void main(String[] args) {
        Person javier = Person.builder()
                .firstName("Javier")
                .lastName("Pereira")
                .phone(new CustomPhoneNumber(1, "094XXXXXX", "secret")
                ).build();

        RuntimeTypeAdapterFactory<PhoneNumber> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory
                .of(PhoneNumber.class, "type")
                .registerSubtype(CustomPhoneNumber.class, "CustomPhone")
                .registerSubtype(PhoneNumber.class, "Phone");
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(runtimeTypeAdapterFactory).create();

        String javierJson =gson.toJson(javier);
        System.out.println(javierJson);
        Person javier2 = gson.fromJson(javierJson, Person.class);

        System.out.println(javier2);



    }
}

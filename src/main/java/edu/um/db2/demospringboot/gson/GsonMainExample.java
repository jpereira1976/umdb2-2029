package edu.um.db2.demospringboot.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.um.db2.demospringboot.xstream.CustomPhoneNumber;
import edu.um.db2.demospringboot.xstream.Person;

public class GsonMainExample {

    public static void main(String[] args) {
        Person javier = Person.builder()
                .firstName("Javier")
                .lastName("Pereira")
                .phone(new CustomPhoneNumber(1, "094XXXXXX", "secret")
                ).build();

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        String javierJson = gson.toJson(javier);
        System.out.println(javierJson);
        Person javier2 = gson.fromJson(javierJson, Person.class);

        System.out.println(javier2);
    }
}

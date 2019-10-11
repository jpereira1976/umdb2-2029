package edu.um.db2.demospringboot.primer_parcial;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import edu.um.db2.demospringboot.xstream.CustomPhoneNumber;
import edu.um.db2.demospringboot.xstream.PhoneNumber;

public class JsonToAnimal {
    public static void main(String[] args) {
        RuntimeTypeAdapterFactory<Animal> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory
                .of(Animal.class, "type")
                .registerSubtype(Dog.class, "dog")
                .registerSubtype(Cat.class, "cat");
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(runtimeTypeAdapterFactory).create();
        Cat cat = (Cat)gson.fromJson(
                "{\"name\":\"Tom\", \"eyeColor\":\"blue\", \"type\":\"cat\"}",
                Animal.class);
        System.out.println(cat.getName() + " " + cat.getEyeColor());
        Dog dog = (Dog)gson.fromJson(
                "{\"name\":\"Teo\", \"color\":\"black\", \"type\":\"dog\"}",
                Animal.class);
        System.out.println(dog.getName() + " " + dog.getColor());
    }
}

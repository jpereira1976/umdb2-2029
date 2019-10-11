package edu.um.db2.demospringboot.primer_parcial;

import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class TransactionToJson {
    public static void main(String[] args) {
        System.out.println(
                new GsonBuilder().create().toJson(
                        Transaction.builder().id("1").movements(
                                Arrays.asList(
                                        Movement.builder()
                                                .accountId("C1")
                                                .amount(1000.0).build(),
                                        Movement.builder()
                                                .accountId("C2")
                                                .amount(-1000.0).build())
                        ).build()
                )
        );
    }
}

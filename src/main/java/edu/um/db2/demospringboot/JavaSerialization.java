package edu.um.db2.demospringboot;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class JavaSerialization {

    public static void main(String[] args) throws Exception {
       /*Factura factura = Factura.builder()
               .cliente("Pepe")
               .number(1000L)
               .total(10000.0).build();

        try (FileOutputStream fo =
                     new FileOutputStream("factura.ser")) {
            try (ObjectOutputStream oo = new ObjectOutputStream(fo)) {
                oo.writeObject(factura);
            }
        }*/

        try (FileInputStream fi = new FileInputStream("factura.ser")) {
            try (ObjectInputStream oi = new ObjectInputStream(fi)) {
                Factura facturaLeida = (Factura)oi.readObject();
                System.out.println(facturaLeida);
            }
        }
    }
}

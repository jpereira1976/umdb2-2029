package edu.um.db2.demospringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public Saludo hello() {
        return new Saludo("Hello", "Hola");
    }
}

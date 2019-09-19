package edu.um.db2.demospringboot.inheritance;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/myproduct")
public class MyProductController {

    MyProductRepository repository;

    public MyProductController(MyProductRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/")
    public void save(@RequestBody MyProduct product) {
        repository.save(product);
    }

    @GetMapping("/{id}")
    public MyProduct load(@PathVariable Integer id) {
        MyProduct product = repository.getOne(id);
        //return product;
        return (MyProduct)Hibernate.unproxy(product);
    }
}





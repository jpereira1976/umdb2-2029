package edu.um.db2.demospringboot.mongo;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    MongoDatabase database;

    public TransactionController(MongoDatabase database) {
        this.database = database;
    }

    @PostMapping("/")
    public void newTransaction(@RequestBody String transactionJson) {
        database.getCollection("transacciones")
                .insertOne(Document.parse(transactionJson));
    }
}

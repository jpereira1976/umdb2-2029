package edu.um.db2.demospringboot.mongo;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {
    MongoDatabase database;

    public TestController(MongoDatabase database) {
        this.database = database;
    }

    @PostMapping("/")
    public void insert(@RequestBody String studentJson) {
        database.getCollection("student")
                .insertOne(Document.parse(studentJson));
    }

    @GetMapping("/{pos}")
    public String get(@PathVariable int pos) {
        FindIterable<Document> iterable = database
                .getCollection("student").find();
        Document result = null;
        for (Document document : iterable) {
            pos--;
            if (pos == 0) {
                result = document;
                break;
            }
        }
        return result.toJson();
    }

}

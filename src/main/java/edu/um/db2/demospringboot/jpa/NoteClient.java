package edu.um.db2.demospringboot.jpa;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class NoteClient {

    public static void main(String[] args) throws  Exception{
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPost post = new HttpPost("http://localhost:8080/note");
            post.setHeader("Content-Type", "application/json");
            post.setEntity(new StringEntity("{\n" +
                    "\t\"title\":\"titulo...\",\n" +
                    "\t\"content\":\"content...\"\n" +
                    "}"));
            try (CloseableHttpResponse response = httpclient.execute(post)) {
                if (!(response.getStatusLine().getStatusCode() >= 200
                        && response.getStatusLine().getStatusCode() < 300))
                    throw new RuntimeException("Ohhhh!!!");
                System.out.println("Respuesta : "
                        + EntityUtils.toString(response.getEntity()));
                System.out.println("POST completado!!!!");
            }
        }

        RestTemplate restTemplate =
                new RestTemplate();
        HttpEntity<Note> body = new HttpEntity<>(
                Note.builder().title("title template")
                        .content("content template").build());
        ResponseEntity<String> response =
                restTemplate.exchange("http://localhost:8080/note",
                        HttpMethod.POST, body, String.class);
        System.out.println("RestTemplate respone : " + response.getBody());
    }
}

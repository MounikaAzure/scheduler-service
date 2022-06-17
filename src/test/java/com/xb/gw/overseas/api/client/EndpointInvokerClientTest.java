package com.xb.gw.overseas.api.client;

import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

import java.util.HashMap;

//@SpringBootTest
class EndpointInvokerClientTest {
    static GenericWebClient endpointInvokerClient = new GenericWebClient();

    public static void main(String[] args) {

        Person p = new Person();
        p.setId(1);
        p.setName("ram");
        Mono<ClientResponse> post = endpointInvokerClient.post("http://localhost:9090/person", p,  new HashMap<>(), 5);
        post.subscribe(clientResponse -> {
            // here you can access headers and status code
            ClientResponse.Headers headers = clientResponse.headers();
            HttpStatus stausCode = clientResponse.statusCode();
            Mono<Person> bodyToMono = clientResponse.bodyToMono(Person.class);
            bodyToMono.subscribe(person -> {
                // here you can access the body
                System.out.println("body:" + person);
                // and you can also access headers and status code if you need
                System.out.println("headers:" + headers.asHttpHeaders());
                System.out.println("stausCode:" + stausCode);
            });

        });
//        ClientResponse block = post.block();
        System.out.println("done");

    }
}
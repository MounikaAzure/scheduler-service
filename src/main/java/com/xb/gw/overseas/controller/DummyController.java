package com.xb.gw.overseas.controller;

import com.xb.gw.overseas.model.admin_reject.AdminRejectMessage;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class DummyController {

    @PostMapping("/person")
    public ResponseEntity<?> getOverseasLookupResponse2(@RequestBody Person person){
        System.out.println("person object ");
        person.setUpdatedTime(LocalDateTime.now());
        return ResponseEntity.accepted().body(person);
    }



        @PostMapping("/in-overseas")
    public ResponseEntity<?> getOverseasLookupResponse(@RequestBody AdminRejectMessage adminRejectMessage){
        // don nothing , return url
        System.out.println("admin reject req "+adminRejectMessage);
        return ResponseEntity.accepted().build();
    }

    @Data
    static class Person{
        private int id;
        private String name;
        LocalDateTime updatedTime;
    }
}
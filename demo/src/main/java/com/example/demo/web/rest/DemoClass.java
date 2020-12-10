package com.example.demo.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo/api/")
public class DemoClass {

    @GetMapping("consultar")
    public ResponseEntity<?> consultar(){
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}

package com.example.demoTest.controller;

import com.example.demoTest.service.HelloServiceImp;
import com.example.demoTest.service.IHelloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private IHelloService helloService;

    public HelloController(HelloServiceImp helloService){
        this.helloService = helloService  ;
    }

    @GetMapping("/hello ")
    public ResponseEntity<?> sayHello (@RequestParam String name){
        return new ResponseEntity<>(helloService.sayHelloService(name), HttpStatus.OK);
      }

}

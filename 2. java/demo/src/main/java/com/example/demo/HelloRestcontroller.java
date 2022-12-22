package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class HelloRestcontroller {

  @GetMapping("/")
  public String sayHello() {
    return "Hello World!";
  }

  @GetMapping("/hello/{name}")
  public String sayHello(@PathVariable String name) {
    return "Hello " + name;
  }
}

package com.example.demoTest.service;

import com.example.demoTest.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImp implements IHelloService {

    @Override
    public ResponseDto sayHelloService(String name){
        return new ResponseDto("Hola, como estas " + name    );
    }

}

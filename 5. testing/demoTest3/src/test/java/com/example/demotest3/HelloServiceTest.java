package com.example.demotest3;

import com.example.demotest3.dto.ResponseDto;
import com.example.demotest3.repository.HelloRepositoryImp;
import com.example.demotest3.service.HelloServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class HelloServiceTest {

    private HelloServiceImp helloService;

    public HelloServiceTest (HelloRepositoryImp helloRepository){
        helloService = new HelloServiceImp(helloRepository);
    }

    @Test
    @DisplayName("Camino feliz")
    void sayHelloServiceOK(){
        //arrange
        String name= "null";
        //HelloServiceImp helloService = new HelloServiceImp();
        ResponseDto expectedResult = new ResponseDto("Hola, como estas null");

        //act
        ResponseDto actual =  helloService.sayHelloService(name);
        //assert
        Assertions.assertEquals(expectedResult,actual);

    }

    @Test
    @DisplayName("Lanza Excepcion por String null")
    void sayHelloServiceThrowException(){

    }
}

package com.example.demotest3;

import com.example.demotest3.dto.ResponseDto;
import com.example.demotest3.entity.Repuesta;
import com.example.demotest3.repository.HelloRepositoryImp;
import com.example.demotest3.repository.IHelloRepository;
import com.example.demotest3.service.HelloServiceImp;
import com.example.demotest3.service.IHelloService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HelloServiceConMockTest {
    @Mock
    HelloRepositoryImp helloRepository;

    @InjectMocks
    HelloServiceImp helloService;

    @Test
    void sayHelloServiceTestOk(){
        //arrange
        String name = "martin";
        ResponseDto expectedResult = new ResponseDto("Hola, como estas martin");
        Repuesta res = new Repuesta("Hola, como estas martin");

        when(helloRepository.saludoRepository(anyString())).thenReturn(res);

        //act
        ResponseDto actual = helloService.sayHelloService(name);
        //assert

        Assertions.assertEquals(expectedResult,actual);
    }
}

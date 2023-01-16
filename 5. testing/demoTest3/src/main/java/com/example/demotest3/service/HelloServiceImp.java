package com.example.demotest3.service;

import com.example.demotest3.dto.ResponseDto;
import com.example.demotest3.entity.Repuesta;
import com.example.demotest3.repository.HelloRepositoryImp;
import com.example.demotest3.repository.IHelloRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImp  implements IHelloService{

    IHelloRepository helloRepository;

    public HelloServiceImp(HelloRepositoryImp helloRepository){
        this.helloRepository=helloRepository;
    }
    @Override
    public ResponseDto sayHelloService(String name) {
        if(name == null){
            throw new RuntimeException();
        }else{
            ObjectMapper mapper = new ObjectMapper();
            Repuesta resp =  helloRepository.saludoRepository(name);
            ResponseDto responseDto = mapper.convertValue(resp, ResponseDto.class);
            return responseDto;
        }

    }
}

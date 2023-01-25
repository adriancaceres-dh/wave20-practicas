package com.bootcamp.qaTesters.service;

import com.bootcamp.qaTesters.dto.MessageDto;
import com.bootcamp.qaTesters.dto.TestCaseDto;
import com.bootcamp.qaTesters.entity.TestCase;
import com.bootcamp.qaTesters.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class TestCaseService implements ITestCaseService {
    @Autowired
    private ITestCaseRepository testRepo;
    private ModelMapper mapper = new ModelMapper();

    @Override
    public MessageDto createEntity(TestCaseDto testCaseDto) {
        if(testCaseDto.getId() != null)
            throw new RuntimeException("No se permite el envío de IDs");
        var entity = mapper.map(testCaseDto, TestCase.class);
        entity =  testRepo.save(entity);

        if(entity.getIdCase() != null)
           return MessageDto.builder()
                   .mesage("Se creó correctamente el testcse")
                   .action("CREATED")
                   .build();
        else throw new RuntimeException("No se pudo crear el testcase");
    }

    @Override
    public MessageDto updateEntity(TestCaseDto testCaseDto) {
        if(testCaseDto.getId() == null)
            throw new RuntimeException("El id es necesario");
        var entity = mapper.map(testCaseDto, TestCase.class);
        entity = testRepo.save(entity);

        if(entity.getIdCase() != null)
           return MessageDto.builder()
                   .mesage("Se actualizó el testcase")
                   .action("UPDATE")
                   .build();
        else
            throw new RuntimeException("No se pudo actualizar el testcase");
    }

    @Override
    public TestCaseDto getEntityById(Long id) {
        var entity = testRepo.findById(id);
        if(entity == null)
            throw new RuntimeException("No se encontró el testcase");

        return mapper.map(entity, TestCaseDto.class);
    }

    @Override
    public List<TestCaseDto> getAllEntities() {
        var list = testRepo.findAll();
        return list.stream().map(
                testCase -> mapper.map(testCase, TestCaseDto.class)
        ).collect(Collectors.toList());
    }

    @Override
    public MessageDto deleteEntity(Long id) {
        TestCaseDto test = this.getEntityById(id);

        if(test != null) {
            testRepo.deleteById(id);
            return MessageDto.builder()
                    .mesage("Se eliminó el testcase")
                    .action("DELETE")
                    .build();
        }
        else {
            throw new RuntimeException("No se pudo eliminar el testcase");
        }

    }

    @Override
    public List<TestCaseDto> findByUpdateDate(LocalDate date) {
        var test = testRepo.findTestCaseByLastUpdateGreaterThan(date);
        return test.stream().map(
                testCase -> mapper.map(testCase, TestCaseDto.class)
        ).collect(Collectors.toList());
    }
}

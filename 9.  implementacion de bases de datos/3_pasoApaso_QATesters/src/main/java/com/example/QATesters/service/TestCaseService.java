package com.example.QATesters.service;

import com.example.QATesters.dto.MessageDTO;
import com.example.QATesters.dto.TestCaseDTO;
import com.example.QATesters.entity.TestCase;
import com.example.QATesters.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements ITestCaseService{

    @Autowired
    private ITestCaseRepository testCaseRepository;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public MessageDTO createEntity(TestCaseDTO testCaseDTO) {

        if(testCaseDTO.getIdCase() != null)
            throw new RuntimeException("No se permite el envio de IDs");

        var entity = mapper.map(testCaseDTO, TestCase.class);

        entity = testCaseRepository.save(entity);

        if(entity.getIdCase() != null)
            return MessageDTO.builder()
                    .message("Se creo exitosamente el testcase")
                    .action("CREATED")
                    .build();
        else
            throw new RuntimeException("No pudo crearse el testcase");
    }

    @Override
    public MessageDTO updateEntity(TestCaseDTO testCaseDTO) {

        if(!testCaseRepository.existsById(testCaseDTO.getIdCase()))
            throw new RuntimeException("No se permite el envio de IDs nulos o inexistentes para actualizar");

        var entity = mapper.map(testCaseDTO, TestCase.class);

        entity = testCaseRepository.save(entity);

        if(entity.getIdCase() != null)
            return MessageDTO.builder()
                    .message("Se actualizo exitosamente el testcase")
                    .action("UPDATED")
                    .build();
        else
            throw new RuntimeException("No pudo actualizarse el testcase");
    }

    @Override
    public TestCaseDTO getEntityById(Long id) {
        if(!testCaseRepository.existsById(id)){
            throw new RuntimeException("No existe el TestCase");
        }

        Optional<TestCase> testCase = testCaseRepository.findById(id);

        return mapper.map(testCase, TestCaseDTO.class);
    }

    @Override
    public List<TestCaseDTO> getAllEntities() {

        var list = testCaseRepository.findAll();

        return list.stream().map(
                testCase -> mapper.map(testCase, TestCaseDTO.class)
        ).collect(Collectors.toList());
    }

    @Override
    public MessageDTO deleteEntity(Long id) {
        if(!testCaseRepository.existsById(id)){
            throw new RuntimeException("No existe el TestCase a eliminar");
        }

        testCaseRepository.deleteById(id);

        return MessageDTO.builder()
                .message("Se elimino exitosamente el testcase")
                .action("DELETED")
                .build();
    }

    @Override
    public List<TestCaseDTO> findByUpdateDate(LocalDate date) {

        var tests = testCaseRepository.findTestCaseByLastUpdateGreaterThanAndPassedIsTrue(date);

        return tests.stream().map(
                testCase -> mapper.map(testCase, TestCaseDTO.class)
        ).collect(Collectors.toList());
    }
}

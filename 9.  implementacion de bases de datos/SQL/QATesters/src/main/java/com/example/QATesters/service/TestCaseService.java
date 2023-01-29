package com.example.QATesters.service;

import com.example.QATesters.dto.MessageDTO;
import com.example.QATesters.dto.TestCaseDTO;
import com.example.QATesters.model.TestCase;
import com.example.QATesters.repository.ITestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements ITestCaseService{

    @Autowired
    ITestCaseRepository testCaseRepository;
    private ModelMapper mapper = new ModelMapper();
    @Override
    public MessageDTO createEntity(TestCaseDTO testCaseDTO) {

        var entity = mapper.map(testCaseDTO, TestCase.class);
        entity = testCaseRepository.save(entity);

        if(entity.getId() != null)
            return MessageDTO.builder()
                    .message("Se ha creado el test case correctamente")
                    .action("CREATED")
                    .build();
        else
            throw new RuntimeException("No pudo crearse el testcase");
    }

    @Override
    public TestCaseDTO getEntityById(Long id) {

        return mapper.map(testCaseRepository.findById(id), TestCaseDTO.class);
    }

    @Override
    public List<TestCaseDTO> getAllEntities() {

        var list = testCaseRepository.findAll();

        return list.stream().map(testCase -> mapper.map(testCase, TestCaseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public MessageDTO updateEntity(Long id, TestCaseDTO testCaseDTO) {
        if(testCaseRepository.findById(id).isPresent()) {
            var entity = testCaseRepository.findById(id).get();
            entity.setTested(testCaseDTO.getTested());
            entity.setPassed(testCaseDTO.getPassed());
            entity.setNumberOfTries(testCaseDTO.getNumberOfTries());
            entity.setLastUpdate(testCaseDTO.getLastUpdate());
            testCaseRepository.save(entity);

            return MessageDTO.builder()
                    .message("Test case actualizado correctamente")
                    .action("UPDATED")
                    .build();
        }
        else
            throw new RuntimeException("No se encontro el usuario");
    }

    @Override
    public MessageDTO deleteEntity(Long id) {
        testCaseRepository.deleteById(id);
        return MessageDTO.builder()
                .message("Test case eliminado correctamente")
                .action("DELETED")
                .build();
    }

    @Override
    public List<TestCaseDTO> findByUpdateDate(LocalDate date) {
        var tests = testCaseRepository.findTestCaseByLastUpdateGreaterThan(date);
        return tests.stream()
                .map(testCase -> mapper.map(testCase, TestCaseDTO.class))
                .collect(Collectors.toList());
    }
}

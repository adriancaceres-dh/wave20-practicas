package com.example.qa_tester.service;

import com.example.qa_tester.dto.request.TestCaseDTORequest;
import com.example.qa_tester.dto.response.TestCaseDTOResponse;
import com.example.qa_tester.entity.TestCase;
import com.example.qa_tester.exception.NotFoundException;
import com.example.qa_tester.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements ITestCaseService {

    @Autowired
    ITestCaseRepository testCaseRepository;

    private final ModelMapper mapper = new ModelMapper();

    public TestCaseService() {
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true);
    }

    @Override
    public TestCaseDTOResponse addTestCase(TestCaseDTORequest testCaseDTO) {
        TestCase testCase = mapper.map(testCaseDTO, TestCase.class);
        TestCase testCaseCreated = testCaseRepository.save(testCase);
        return mapper.map(testCaseCreated, TestCaseDTOResponse.class);
    }

    @Override
    public List<TestCaseDTOResponse> getTestCases(LocalDate last_update) {
        if (last_update == null) {
            return testCaseRepository.findAll().stream().map(t -> mapper.map(t, TestCaseDTOResponse.class))
                    .collect(Collectors.toList());
        }
        return testCaseRepository.findAll().stream().filter(x -> x.getLast_update().isAfter(last_update)).map(t -> mapper.map(t, TestCaseDTOResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public TestCaseDTOResponse getTestCaseById(Long id) {
        return mapper.map(testCaseRepository.getReferenceById(id), TestCaseDTOResponse.class);
    }

    @Override
    public TestCaseDTOResponse updateTestCase(TestCaseDTORequest testCaseDTO, Long id) {
        if (!testCaseRepository.existsById(id)) {
            throw new NotFoundException("Ese caso de prueba no existe.");
        }
        TestCase joya = mapper.map(testCaseDTO, TestCase.class);
        joya.setId_case(id);
        TestCase TestCaseUpdated = testCaseRepository.save(joya);
        return mapper.map(TestCaseUpdated, TestCaseDTOResponse.class);
    }

    @Override
    public String deleteTestCase(Long id) {
        if (!testCaseRepository.existsById(id)) {
            throw new NotFoundException("Ese caso de prueba no existe.");
        }
        testCaseRepository.deleteById(id);
        return "El caso de prueba ha sido eliminado.";
    }
}

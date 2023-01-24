package com.bootcamp.QA_Testers.service;

import com.bootcamp.QA_Testers.dto.MessageExceptionDTO;
import com.bootcamp.QA_Testers.dto.request.TestCaseRequestDTO;
import com.bootcamp.QA_Testers.dto.response.TestCaseResponseDTO;
import com.bootcamp.QA_Testers.exceptions.TestNotFoundException;
import com.bootcamp.QA_Testers.model.TestCase;
import com.bootcamp.QA_Testers.repository.ITestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements ITestCaseService{

    @Autowired
    ITestCaseRepository iTestCaseRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public Long createTestCase (TestCaseRequestDTO testCaseRequestDTO){
        TestCase test = iTestCaseRepository.save(modelMapper.map(testCaseRequestDTO, TestCase.class));
        return test.getId_case();
    }

    public List<TestCaseResponseDTO> findAll (LocalDate last_update){
        return iTestCaseRepository.findAll().stream()
                .filter(test->(last_update==null)?true:test.getLast_update().isAfter(last_update))
                .map(test->modelMapper.map(test, TestCaseResponseDTO.class))
                .collect(Collectors.toList());
    }

    public TestCaseResponseDTO findById(Long id){
        return iTestCaseRepository.findById(id)
                .map(test->modelMapper.map(test, TestCaseResponseDTO.class))
                .orElseThrow(()->new TestNotFoundException(new MessageExceptionDTO("No se encontro el test con id: "+id)));
    }

    public TestCaseResponseDTO updateById(Long id, TestCaseRequestDTO testCaseRequestDTO){
        if(iTestCaseRepository.existsById(id)){
            TestCase test = iTestCaseRepository.save(modelMapper.map(testCaseRequestDTO,TestCase.class));
            return modelMapper.map(test, TestCaseResponseDTO.class);
        }
        throw new TestNotFoundException(new MessageExceptionDTO("No se encontro el test a actualizar con id: "+id));
    }

    public Boolean deleteById(Long id){
        if(iTestCaseRepository.existsById(id)){
            iTestCaseRepository.deleteById(id);
            return true;
        }
        throw new TestNotFoundException(new MessageExceptionDTO("No se encontro el test a eliminar con id: "+id));
    }

}

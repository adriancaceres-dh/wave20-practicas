package com.example.qatesters.service;

import com.example.qatesters.dtos.MessageDto;
import com.example.qatesters.dtos.TestCaseDto;
import com.example.qatesters.exceptions.NotNullIdException;
import com.example.qatesters.exceptions.TestCaseNotFoundException;
import com.example.qatesters.model.TestCase;
import com.example.qatesters.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService {

  private final ModelMapper mapper = new ModelMapper();
  private final ITestCaseRepository testCaseRepository;

  public TestCaseService(ITestCaseRepository testCaseRepository) {
    this.testCaseRepository = testCaseRepository;
  }

  @Override
  public MessageDto create(TestCaseDto dto) {
    if(dto.getIdCase() != null) {
      throw new NotNullIdException("No se permite el envio de IDs");
    }
    var entity = mapper.map(dto, TestCase.class);
    entity = testCaseRepository.save(entity);
    if (entity.getIdCase() == null) {
      throw new RuntimeException("Error creating test case");
    }
    return MessageDto.builder()
            .message("Test case created successfully")
            .action("CREATE")
            .build();
  }

  @Override
  public TestCaseDto findById(Long id) {
    var entity = testCaseRepository.findById(id);
    if (entity.isPresent()) {
      return mapper.map(entity.get(), TestCaseDto.class);
    }
    else throw new TestCaseNotFoundException("The test case with id " + id + " was not found");
  }

  @Override
  public MessageDto update(TestCaseDto testCaseDto) {
    if(!testCaseRepository.existsById(testCaseDto.getIdCase())) {
      throw new TestCaseNotFoundException("The test case with id " + testCaseDto.getIdCase() + " was not found");
    }

    var entity = mapper.map(testCaseDto, TestCase.class);
    entity = testCaseRepository.save(entity);
    if(entity.getIdCase() == null) {
      throw new RuntimeException("No pudo actualizarse el testcase");
    }
    return MessageDto.builder()
            .message("Se actualizo exitosamente el testcase")
            .action("UPDATED")
            .build();
  }

  @Override
  public MessageDto delete(Long id) {
    if (!testCaseRepository.existsById(id)) {
      throw new TestCaseNotFoundException("The test case with id: " + id + " was not found");
    }
    testCaseRepository.deleteById(id);
    return MessageDto.builder()
            .message("Test case deleted successfully")
            .action("DELETE")
            .build();
  }

  @Override
  public List<TestCaseDto> findAll() {
    return testCaseRepository.findAll().stream().map(
        testCase -> mapper.map(testCase, TestCaseDto.class)
    ).toList();
  }

  @Override
  public List<TestCaseDto> findTestCaseByLastUpdateGreaterThan(LocalDate date) {
    return testCaseRepository.findTestCaseByLastUpdateGreaterThan(date).stream().map(
        testCase -> mapper.map(testCase, TestCaseDto.class)
    ).toList();
  }
}

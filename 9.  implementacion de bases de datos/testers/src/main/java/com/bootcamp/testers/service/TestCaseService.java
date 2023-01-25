package com.bootcamp.testers.service;

import com.bootcamp.testers.dto.MessageDto;
import com.bootcamp.testers.dto.TestCaseRequestDto;
import com.bootcamp.testers.dto.TestCaseResponseDto;
import com.bootcamp.testers.model.TestCase;
import com.bootcamp.testers.repository.TestCaseRepository;
import com.bootcamp.testers.util.Param;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import java.util.stream.Collectors;

@Service
public class TestCaseService implements ITestCaseService {

    private final TestCaseRepository testCaseRepo;
    private final ModelMapper mapper;

    public TestCaseService(TestCaseRepository testCaseRepository) {
        testCaseRepo = testCaseRepository;
        mapper = new ModelMapper();
    }

    @Override
    public MessageDto createTestCase(TestCaseRequestDto testCaseDto) {
        Long id = saveTestCase(mapper.map(testCaseDto, TestCase.class));

        return MessageDto.builder()
                .message(Param.getString("CaseCreated") + id)
                .action("CREATE")
                .build();
    }

    @Override
    public List<TestCaseResponseDto> getAllTestCase() {
        return testCaseRepo.findAll().stream()
                .map(testCase -> mapper.map(testCase, TestCaseResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TestCaseResponseDto getTestCaseById(Long id) {
       if(testCaseRepo.existsById(id)) {
           return mapper.map(testCaseRepo.findById(id), TestCaseResponseDto.class);
       }
        throw new RuntimeException("The test case doesn't exist");
    }

    @Override
    public MessageDto updateTestCaseById(Long id, TestCaseRequestDto testCaseDto) {
        if (testCaseRepo.existsById(id)) {
            TestCase updatedTestCase = mapper.map(testCaseDto, TestCase.class);
            updatedTestCase.setIdCase(id);
            saveTestCase(updatedTestCase);
            return MessageDto.builder()
                    .message(Param.getString("CaseUpdated"))
                    .action("UPDATE")
                    .build();
        }
        throw new RuntimeException("The test case doesn't exist");
    }

    @Override
    public MessageDto deleteTestCase(Long id) {
       if(testCaseRepo.existsById(id)) {
           testCaseRepo.deleteById(id);
           return MessageDto.builder()
                   .message(Param.getString("CaseDeleted") + id)
                   .action("DELETE")
                   .build();
       }
       throw new RuntimeException("The test case doesn't exist");
    }

    @Override
    public List<TestCaseResponseDto> findByDate(LocalDate date){
        return testCaseRepo.findDateTimeBefore(date).stream()
                .map(tc -> mapper.map(tc, TestCaseResponseDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<TestCaseResponseDto> findByDateE(LocalDate date){
        return testCaseRepo.findByLastUpdateIsAfter(date).stream()
                .map(tc -> mapper.map(tc, TestCaseResponseDto.class))
                .collect(Collectors.toList());
    }

    private Long saveTestCase(TestCase testCase) {
        return testCaseRepo.save(testCase).getIdCase();
    }
}

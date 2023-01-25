package com.bootcamp.qa_testers.qa_testers.service;

import com.bootcamp.qa_testers.qa_testers.dto.MessageDTO;
import com.bootcamp.qa_testers.qa_testers.dto.TestCaseDTO;
import com.bootcamp.qa_testers.qa_testers.entity.TestCase;
import com.bootcamp.qa_testers.qa_testers.repository.TestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TestCaseServiceImpl implements TestCaseService{
    TestCaseRepository testCaseRepository;

    private ModelMapper mapper = new ModelMapper();

    public TestCaseServiceImpl(TestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public MessageDTO create(TestCaseDTO testCaseDTO) {
        TestCase testCase = mapper.map(testCaseDTO, TestCase.class);
        testCase = testCaseRepository.save(testCase);
        if(testCase.getIdCase() != null){
         return MessageDTO.builder()
                 .message("Se creo un nuevo Test Case")
                 .action("CREATE")
                 .build();
        }
        else throw new RuntimeException("No se pudo crear el Test Case");
    }

    @Override
    public MessageDTO update(TestCaseDTO testCaseDTO) {
        return null;
    }

    @Override
    public TestCaseDTO getById(Long id) {
        return null;
    }

    @Override
    public List<TestCaseDTO> getAll() {
        return null;
    }

    @Override
    public MessageDTO deleteById(Long id) {
        return null;
    }
}

package com.meli.obtenerdiploma.serviceTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.meli.obtenerdiploma.helper.StudentDTOHelper.dummyStudent;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentDAO studentDAO;

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void shouldCreate() {
        //Arrange
        StudentDTO studentDTO = dummyStudent();
        //Act
        studentService.create(studentDTO);
        //Assert
        verify(studentDAO, atLeastOnce()).save(studentDTO);
    }

    @Test
    public void shouldRead() {
        //Arrange
        StudentDTO studentDTO = dummyStudent();
        //Act
        when(studentDAO.findById(anyLong())).thenReturn(studentDTO);
        //Assert
        assertNotNull(studentService.read(anyLong()));
        verify(studentDAO, atLeastOnce()).findById(anyLong());
    }

    @Test
    void shouldUpdate() {
        //Arrange
        StudentDTO studentDTO = dummyStudent();
        //Act
        studentService.update(studentDTO);
        //Assert
        verify(studentDAO,  atLeastOnce()).save(studentDTO);
    }

    @Test
    void shouldDelete() {
        //Arrange
        Long id = 1L;
        //Act
        studentService.delete(id);
        //Assert
        verify(studentDAO, atLeastOnce()).delete(id);
    }

}

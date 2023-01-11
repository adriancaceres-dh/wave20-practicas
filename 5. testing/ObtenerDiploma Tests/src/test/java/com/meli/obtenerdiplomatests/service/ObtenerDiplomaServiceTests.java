package com.meli.obtenerdiplomatests.service;

import com.meli.obtenerdiplomatests.model.StudentDTO;
import com.meli.obtenerdiplomatests.model.SubjectDTO;
import com.meli.obtenerdiplomatests.repository.StudentDAO;
import com.meli.obtenerdiplomatests.repository.StudentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
class ObetenerDiplomaServiceTests {

	@Mock
	StudentDAO studentDAO;
	@InjectMocks
	ObtenerDiplomaService obtenerDiplomaService;


	@BeforeAll
	public static void loadRepository(){
		SubjectDTO sub1 = new SubjectDTO("Materia 1", 5d);
		SubjectDTO sub2 = new SubjectDTO("Materia 2", 1d);
		SubjectDTO sub3 = new SubjectDTO("Materia 3", 9d);
		StudentDTO studentDTO1 = new StudentDTO(null, "Student1", "mensaje", 0d, List.of(sub1, sub2, sub3));
		//studentService.create(studentDTO1);

		SubjectDTO sub4 = new SubjectDTO("Materia 4", 15d);
		SubjectDTO sub5 = new SubjectDTO("Materia 5", 7d);
		StudentDTO studentDTO2 = new StudentDTO(null, "Student2", "mensaje 2", 0d, List.of(sub4, sub5));
	//	studentService.create(studentDTO2);
	}

	@Test
	public void getGreetingMessageCongratulationsOK(){
		// arrange
		SubjectDTO sub4 = new SubjectDTO("Materia 4", 15d);
		SubjectDTO sub5 = new SubjectDTO("Materia 5", 7d);
		StudentDTO studentDTO2 = new StudentDTO(2L, "Student2", "mensaje 2", 0d, List.of(sub4, sub5));
		when(studentDAO.findById(anyLong())).thenReturn(studentDTO2);
		String expectedResult = "El alumno Student2 ha obtenido un promedio de 11. Felicitaciones!";

		//act
		StudentDTO result = obtenerDiplomaService.analyzeScores(2L);

		//assert
		assertEquals(expectedResult,result.getMessage());
	}
	@Test
	public void getGreetingMessageCanImproveOK(){
		// arrange
		SubjectDTO sub4 = new SubjectDTO("Materia 4", 1d);
		SubjectDTO sub5 = new SubjectDTO("Materia 5", 7d);
		StudentDTO studentDTO2 = new StudentDTO(2L, "Student2", "mensaje 2", 0d, List.of(sub4, sub5));
		when(studentDAO.findById(anyLong())).thenReturn(studentDTO2);
		String expectedResult = "El alumno Student2 ha obtenido un promedio de 4. Puedes mejorar.";

		//act
		StudentDTO result = obtenerDiplomaService.analyzeScores(2L);

		//assert
		assertEquals(expectedResult,result.getMessage());
	}

	@Test
	public void calculateAverageOK(){
		// arrange
		SubjectDTO sub4 = new SubjectDTO("Materia 4", 1d);
		SubjectDTO sub5 = new SubjectDTO("Materia 5", 7d);

		StudentDTO studentDTO2 = new StudentDTO(2L, "Student2", "mensaje 2", 0d, List.of(sub4, sub5));
		double expectedResult = 4d;
		when(studentDAO.findById(anyLong())).thenReturn(studentDTO2);

		// act
		StudentDTO result = obtenerDiplomaService.analyzeScores(2L);

		// assert
		assertEquals(expectedResult, result.getAverageScore());
	}

	@Test
	public void analyzeScoresCongratulationsOK(){
		// arrange
		SubjectDTO sub4 = new SubjectDTO("Materia 4", 15d);
		SubjectDTO sub5 = new SubjectDTO("Materia 5", 7d);
		StudentDTO studentDTO2 = new StudentDTO(2L, "Student2", "mensaje 2", 0d, List.of(sub4, sub5));
		when(studentDAO.findById(anyLong())).thenReturn(studentDTO2);

		StudentDTO expectedResult = new StudentDTO(2L, "Student2", "El alumno Student2 ha obtenido un promedio de 11. Felicitaciones!", 11d,List.of(sub4,sub5));

		// act
		StudentDTO result = obtenerDiplomaService.analyzeScores(2L);

		// assert
		assertEquals(expectedResult, result);
	}

	@Test
	public void analyzeScoresCanImproveOK(){
		// arrange
		SubjectDTO sub4 = new SubjectDTO("Materia 4", 1d);
		SubjectDTO sub5 = new SubjectDTO("Materia 5", 7d);
		StudentDTO studentDTO2 = new StudentDTO(2L, "Student2", "mensaje 2", 0d, List.of(sub4, sub5));
		when(studentDAO.findById(anyLong())).thenReturn(studentDTO2);

		StudentDTO expectedResult = new StudentDTO(2L, "Student2", "El alumno Student2 ha obtenido un promedio de 4. Puedes mejorar.", 4d,List.of(sub4,sub5));

		// act
		StudentDTO result = obtenerDiplomaService.analyzeScores(2L);

		// assert
		assertEquals(expectedResult, result);
	}
}
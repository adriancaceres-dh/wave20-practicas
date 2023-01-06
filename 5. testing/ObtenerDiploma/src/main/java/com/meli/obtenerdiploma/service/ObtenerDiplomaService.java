package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.StudentInDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class ObtenerDiplomaService implements IObtenerDiplomaService {

    @Override
    public StudentDTO analyzeScores(StudentInDTO rq) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName(rq.getStudentName());
        studentDTO.setSubjects(rq.getSubjects());
        studentDTO.setAverageScore(calculateAverage(rq.getSubjects()));
        studentDTO.setMessage(getGreetingMessage(rq.getStudentName(), studentDTO.getAverageScore()));

        return studentDTO;
    }

    private String getGreetingMessage(String studentName, Double average) {
        return "El alumno " + studentName + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(average)
                + ((average > 9) ? ". Felicitaciones!" : ". Puedes mejorar.");
    }

    private Double calculateAverage(List<SubjectDTO> scores) {
        return scores.stream()
                .reduce(0D, (partialSum, score)  -> partialSum + score.getScore(), Double::sum)
                / scores.size();
    }
}

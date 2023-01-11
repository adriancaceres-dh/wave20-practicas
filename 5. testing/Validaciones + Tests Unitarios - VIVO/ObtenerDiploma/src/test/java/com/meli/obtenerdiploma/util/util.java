package com.meli.obtenerdiploma.util;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.util.ResourceUtils;

public class util {

    private static String SCOPE;
    private static ObjectWriter mapper;

    public static List<SubjectDTO> getSubjects(boolean godScore) {
        List<SubjectDTO> subjects = new ArrayList<>();
        String[] subjectsName = {"Matemática", "Lengua", "Física", "Química", "Historia",
                "Biología", "Idiomas", "Programación", "Base de datos", "Seguridad Informática"};

        int numero = (int) ((Math.random() * ((10 - 1) + 1)) + 1);
        for (int i = 0; i < numero; i++) {
            double notas = Math.rint(((Math.random() * (9 - 4) + 1) + 4) * 100) / 100;
            if (godScore) {
                notas = Math.rint((((Math.random() * (10 - 9) + 1)) + 8)*100)/100;
            }
            SubjectDTO subject = new SubjectDTO(subjectsName[i], Double.valueOf(notas));
            subjects.add(subject);
        }
        return subjects;
    }

    public static StudentDTO getStudent(Long id, String name, List<SubjectDTO> subjects) {
        StudentDTO stu = new StudentDTO();
        stu.setId(id);
        stu.setStudentName(name);
        stu.setSubjects(subjects);
        return stu;
    }

    public static void emptyFile(){
        Properties properties = new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            SCOPE = properties.getProperty("api.scope");
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/users.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        writer.print("[]");
        writer.close();
    }
}

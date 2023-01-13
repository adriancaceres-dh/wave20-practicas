package com.meli.obtenerdiplomatests.util;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiplomatests.model.StudentDTO;
import com.meli.obtenerdiplomatests.model.SubjectDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;

public class TestUtils {
    private static String SCOPE;
    private static ObjectWriter mapper;
    public static void emptyUsersFile() {
        Properties properties = new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            SCOPE = properties.getProperty("api.scope");
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/src/test/resources/users.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        writer.print("[]");
        writer.close();
    }

    public static StudentDTO getStudentId2(){
        SubjectDTO sub1 = new SubjectDTO("Matemática", 10d);
        SubjectDTO sub2 = new SubjectDTO("Física", 8d);
        SubjectDTO sub3 = new SubjectDTO("Química", 4d);
        return new StudentDTO(2L,"Pedro", null, null, List.of(sub1,sub2,sub3));
    }

    public static StudentDTO getStudentToSave(){
        SubjectDTO sub1 = new SubjectDTO("Matemática", 10d);
        SubjectDTO sub2 = new SubjectDTO("Física", 8d);
        SubjectDTO sub3 = new SubjectDTO("Química", 4d);
        return new StudentDTO(1L,"Pedro", null, null, List.of(sub1,sub2,sub3));
    }

}

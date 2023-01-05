package com.bootcamp.be_java_hisp_w20_g1_demarchi.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonReaderUtil {

    public static <T> List<T> parseJson(String json, Class<T> classWhichArray) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            File file = ResourceUtils.getFile(json);
            Class<T[]> arrayClass = (Class<T[]>) Class.forName("[L" + classWhichArray.getName() + ";");
            T[] objs = objectMapper.readValue(file, arrayClass);
            return Arrays.asList(objs);
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}

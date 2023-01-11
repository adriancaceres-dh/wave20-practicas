package com.meli.obtenerdiploma.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class TestsUtilsGenerator {

    private static String SCOPE;

    public static void resetUsersFile() throws IOException {
        Properties properties = new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            SCOPE = properties.getProperty("api.scope");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter writer = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/users.json"), StandardCharsets.UTF_8)) {
            BufferedReader original = new BufferedReader(new InputStreamReader(new FileInputStream("./src/" + SCOPE + "/resources/users_original.json"), StandardCharsets.UTF_8));

            int i;
            while ((i = original.read()) != -1) {
                writer.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

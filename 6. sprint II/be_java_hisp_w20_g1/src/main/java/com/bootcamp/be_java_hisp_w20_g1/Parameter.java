package com.bootcamp.be_java_hisp_w20_g1;

import java.util.HashMap;
import java.util.Map;

public class Parameter {

    private static Map<String, String> stringValues = new HashMap<>() {
        {
            put("PostJsonPath", "classpath:posts.json");
            put("ProductJsonPath", "classpath:products.json");
            put("UserJsonPath", "classpath:users.json");
            put("DateAsc", "date_asc");
            put("DateDesc", "date_desc");
            put("NameAsc", "name_asc");
            put("NameDesc", "name_desc");
            put("NonExistentOrder", "nonExistingOrder");

            put("EX_Path", "Path variable incorrecta");
            put("EX_InvalidRequestBody", "Request body inválido");
            put("EX_ExistingProduct", "El producto ya existe");
            put("EX_InvalidUser", "Usuario invalido.");
            put("EX_NotExistentProduct", "Producto no existente");
            put("EX_NotASeller", "El usuario no es vendedor");
            put("EX_NotExistentUser", "El usuario no existe");
            put("EX_InvalidQueryParamValue", "El valor de ordenamiento no es válido");
            put("EX_InvalidOrder","El valor de ordenamiento no es válido");
        }
    };

    private static Map<String, Integer> integerValues = new HashMap<>() {
        {
            put("InitialId", 1);
            put("InvalidId", 0);
            put("NumberOfDays", 14);
        }
    };

    public static String getString(String key) {
        return stringValues.get(key);
    }

    public static Integer getInteger(String key) {
        return integerValues.get(key);
    }
}

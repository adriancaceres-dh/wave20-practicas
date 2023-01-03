package com.bootcamp.be_java_hisp_w20_g1;

import java.util.HashMap;
import java.util.Map;

public class Parameter {

    private static Map<String, String> stringValues = new HashMap<>(){
        {
            put("PostJsonPath", "classpath:posts.json");
            put("ProductJsonPath", "classpath:products.json");
            put("UserJsonPath", "classpath:users.json");
            put("date_order", "date_asc");

            put("EX_Path","Path variable incorrecta");
            put("EX_RqBody","Request body inválido");
            put("EX_ProductoExistente","El producto ya existe");
            put("EX_UsuarioInvalido","Usuario invalido.");
            put("EX_ProductoInexistente","Producto no existente");
            put("EX_UsuarioNoVendedor","El usuario no es vendedor");
            put("EX_UsuarioInexistente","El usuario no existe");
        }
    };

    private static Map<String, Integer> integerValues = new HashMap<>(){
        {
            put("InitialId", 1);
            put("CantidadDias", 14);
        }
    };
    public static String getString(String key){
       return stringValues.get(key);
    }

    public static Integer getInteger(String key){
        return integerValues.get(key);
    }
}

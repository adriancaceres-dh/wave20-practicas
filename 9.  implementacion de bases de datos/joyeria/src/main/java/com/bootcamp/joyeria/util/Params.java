package com.bootcamp.joyeria.util;

import java.util.HashMap;
import java.util.Map;

public class Params {

    private static Map<String, String> stringValores = new HashMap<>() {
        {
            put("JoyaEliminada", "La joya se ha eliminado satisfactoriamente.");
            put("JoyaNoEncontrada", "No se ha encontrado la joya solicitada.");
            put("JoyaCreada", "Se creó la joya satisfactoriamente con id: ");
            put("JoyaActualizada", "Se actualizó la joya satisfactoriamente.");
        }
    };

    public static String obtenerString(String clave) { return stringValores.get(clave); }
}

package com.bootcamp.testers.util;

import java.util.HashMap;
import java.util.Map;

public class Param {

    private static Map<String, String> stringValues = new HashMap<>() {
        {
            put("CaseCreated", "Test Case was created with id: ");
            put("CaseNotFound", "Requested Test Case was not found.");
            put("CaseDeleted", "Test Case was deleted successfully.");
            put("CaseUpdated", "Test Case was updated successfully.");
        }
    };

    public static String getString(String clave) { return stringValues.get(clave); }
}


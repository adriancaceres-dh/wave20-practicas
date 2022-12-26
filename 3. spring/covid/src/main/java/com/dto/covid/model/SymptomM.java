package com.dto.covid.model;

public class SymptomM {
    int code;
    String name;
    String severityLevel;

    public SymptomM() {
    }

    public SymptomM(int code, String name, String severityLevel) {
        this.code = code;
        this.name = name;
        this.severityLevel = severityLevel;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(String severityLevel) {
        this.severityLevel = severityLevel;
    }

    @Override
    public String toString() {
        return "{" +
                "Código:" + code + '\n' +
                "Nombre:'" + name + '\n' +
                "Nivel de gravedad:'" + severityLevel + '\n' +
                "}\n";
    }
}

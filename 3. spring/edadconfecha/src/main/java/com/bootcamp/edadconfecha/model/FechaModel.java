package com.bootcamp.edadconfecha.model;

import java.time.LocalDate;

public class FechaModel {
    String dia;
    String mes;
    String ano;

    public FechaModel() {
    }

    public FechaModel(String dia, String mes, String ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public LocalDate getAsDate(){
        return LocalDate.parse(this.toString());
    }

    @Override
    public String toString() {
        return ano+"-"+mes+"-"+dia;
    }
}

package com.bootcamp.birthday.birthdaycalculator.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Calculate {

    private static final Date actualDate = new Date();
    private static final long DATE_CONVERSION_CONST = 31556952000L;

    public static String Calculate(String birthDay){

        try{
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date convertedBirthDay = dateFormat.parse(birthDay);
            int age = (int) ((actualDate.getTime() - convertedBirthDay.getTime() )/ DATE_CONVERSION_CONST);
            return Integer.toString(age);
        }
        catch (ParseException e){
            return "Error al intentar realizar la operacion" + e.getMessage();
        }

    }
}

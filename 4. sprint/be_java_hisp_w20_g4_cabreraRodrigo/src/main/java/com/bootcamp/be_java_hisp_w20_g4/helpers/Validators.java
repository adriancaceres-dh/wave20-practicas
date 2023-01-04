package com.bootcamp.be_java_hisp_w20_g4.helpers;

import com.bootcamp.be_java_hisp_w20_g4.excepcion.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g4.model.Category;
import com.bootcamp.be_java_hisp_w20_g4.model.Product;
import com.bootcamp.be_java_hisp_w20_g4.model.Seller;
import com.bootcamp.be_java_hisp_w20_g4.model.User;

public class Validators {

    public static void isValidOrder(String order){
        if (! ((order == null) || order.toLowerCase().equals("name_asc") || order.toLowerCase().equals("name_desc"))) throw new BadRequestException("Parametro de orden incorrecto");
    }
    public static void isValidDateOrder(String order) {
        if (! ((order == null) || order.toLowerCase().equals("date_asc") || order.toLowerCase().equals("date_desc"))) throw new BadRequestException("Parametro de orden incorrecto");
    }
    public static void isValidCategory(Category category){
        if(category == null) throw new BadRequestException("La categoria ingresa no es válida.");
    }
    public static void isValidProduct(Product product){
        if(product == null) throw new BadRequestException("El producto no es válido.");
    }

}

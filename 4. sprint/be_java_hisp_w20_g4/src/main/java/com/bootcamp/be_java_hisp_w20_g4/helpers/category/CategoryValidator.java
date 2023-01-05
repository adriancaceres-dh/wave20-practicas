package com.bootcamp.be_java_hisp_w20_g4.helpers.category;

import com.bootcamp.be_java_hisp_w20_g4.excepcion.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g4.model.Category;
import com.bootcamp.be_java_hisp_w20_g4.model.User;

public class CategoryValidator {
    /**
     * Este método valida que una category no sea nulo
     * En caso de que si sea, lanza exception
     * @param category - Es la categoria que hay que validar
     */
    public static void isValidCategory(Category category){
        if (category == null) throw new BadRequestException("La categoria no es valida.");
    }
}

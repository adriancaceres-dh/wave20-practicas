package com.bootcamp.be_java_hisp_w20_g4_pereyra.helpers;

import com.bootcamp.be_java_hisp_w20_g4_pereyra.excepcion.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.model.Category;

public class CategoryHelper {
    /**
     * Este método valida que una categoria no sea nula.
     * @param category Categoria a validar
     */
    public static void isValidCategory(Category category){
        if (category == null) throw new BadRequestException("La categoria no es válida");
    }

}

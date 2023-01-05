package com.bootcamp.be_java_hisp_w20_g4_pereyra.helpers.publication;

import com.bootcamp.be_java_hisp_w20_g4_pereyra.exception.BadRequestException;

public class PublicationHelper {
    public static void hasPromo(boolean promo){
        if(!promo) throw new BadRequestException("El producto tiene que tener un descuento.");
    }
    public static void hasDiscount(double discount){
        if(discount <= 0) throw new BadRequestException("El descuento del producto tiene que ser mayor a 0.");
    }
}

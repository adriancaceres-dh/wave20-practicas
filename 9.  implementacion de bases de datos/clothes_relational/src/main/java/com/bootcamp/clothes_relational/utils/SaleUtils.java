package com.bootcamp.clothes_relational.utils;

import com.bootcamp.clothes_relational.model.Garment;

import java.util.List;

public final class SaleUtils {

    public static Double getSaleTotal(List<Garment> clothes) {
        return clothes.stream().mapToDouble(garment -> garment.getQuantity() * garment.getPrice()).sum();
    }
}

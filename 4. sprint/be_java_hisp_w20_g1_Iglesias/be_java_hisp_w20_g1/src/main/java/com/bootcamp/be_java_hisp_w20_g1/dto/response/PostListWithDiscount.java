package com.bootcamp.be_java_hisp_w20_g1.dto.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class PostListWithDiscount extends PostResponseDto {
private boolean hasPromo;
private double discount;

public PostListWithDiscount(int userId, int postId, LocalDate date, ProductResponseDto product, int category,
		double price, boolean hasPromo, double discount) {
	super(userId, postId, date, product, category, price);
	this.hasPromo = hasPromo;
	this.discount = discount;
}

public boolean isHasPromo() {
	return hasPromo;
}

public void setHasPromo(boolean hasPromo) {
	this.hasPromo = hasPromo;
}

public double getDiscount() {
	return discount;
}

public void setDiscount(double discount) {
	this.discount = discount;
}




}

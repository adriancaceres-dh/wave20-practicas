package com.bootcamp.be_java_hisp_w20_g2_ambroggio.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import javax.validation.constraints.*;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostWithIdDTO extends PostDTO {

    @NotNull(message = "El id_post no puede estar vacío.") // Se paso a Integer para que pueda agarrar el @ e identificarlo como null.
    @Positive(message = "El id_post debe ser mayor a cero.")
    private Integer postId;

    public PostWithIdDTO(int userId, LocalDate date, ProductDTO product, int category, double price, int postId) {
        super(userId, date, product, category, price);
        this.postId = postId;
    }
}
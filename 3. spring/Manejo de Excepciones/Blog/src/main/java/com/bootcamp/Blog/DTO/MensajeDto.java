package com.bootcamp.Blog.DTO;

import com.bootcamp.Blog.Models.EntradaBlog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MensajeDto {
    private String mensaje;
    private EntradaDto entradaBlog;
}

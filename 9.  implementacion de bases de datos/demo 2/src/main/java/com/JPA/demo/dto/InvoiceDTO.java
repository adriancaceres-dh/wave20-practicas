package com.JPA.demo.dto;


import com.JPA.demo.entity.Client;
import jakarta.persistence.Column;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDTO {

    private Integer id;

    private LocalDate date;

    private ClientSimpleDTO client;

}

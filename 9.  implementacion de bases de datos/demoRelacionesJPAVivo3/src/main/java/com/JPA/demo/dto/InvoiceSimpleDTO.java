package com.JPA.demo.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceSimpleDTO {

    private Integer id;

    private LocalDate date;

}

package com.JPA.demo.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ClientSimpleDTO {
    private Integer id;

    private String email;

    private String cardNumber;
    private PersonDTO person;
}

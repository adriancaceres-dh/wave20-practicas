package com.JPA.demo.dto;

import com.JPA.demo.entity.Invoice;
import com.JPA.demo.entity.Person;
import jakarta.persistence.Column;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private Integer id;

    private String email;

    private String cardNumber;

    private PersonDTO person;

    private List<InvoiceSimpleDTO> invoice;

}

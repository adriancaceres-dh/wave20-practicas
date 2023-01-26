package com.JPA.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private Integer id;

    private String email;

    private String cardNumber;
    private PersonDTO person;
    private List<InvoiceDTO> invoice;

    @Override
    public String toString() {
        return "ClientDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", person=" + person +
                ", invoice=" + invoice +
                '}';
    }
}

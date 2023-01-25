package com.JPA.demo.entity;


import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Cliente")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "numero_tarjeta", length = 20)
    private String cardNumber;

    @OneToMany(mappedBy = "client")
    private List<Invoice> invoices;

    @OneToOne
    private Person person;
}

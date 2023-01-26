package com.JPA.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @OneToOne(cascade = CascadeType.PERSIST)
    private Person person;

    @OneToMany(mappedBy = "client")
    private List<Invoice> invoices;
}

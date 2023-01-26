package com.bootcamp.clothes_relational.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Entity(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long number;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private Double total;
    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;
    @ManyToMany
    @JoinTable(
            name = "sale_garment",
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "garment_id"))
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    private List<Garment> clothes;
}

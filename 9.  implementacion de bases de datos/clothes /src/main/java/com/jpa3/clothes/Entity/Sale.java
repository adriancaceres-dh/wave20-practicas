package com.jpa3.clothes.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "venta")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    @Column()
    private LocalDate date;
    @Column()
    private Double total;
    @Column()
    private String payment_method;

    @OneToMany(mappedBy = "sale")
    @JsonBackReference
    private Set<SalePOC> salePOCs;
}

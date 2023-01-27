package com.bootcamp.showroom.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private Double total;
    @Column(name = "payment_method")
    private String paymentMethod;
    @ManyToMany
    @JoinTable(
            name = "sales_clothing",
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "clothing_id")
    )
    private List<Clothing> clothingList;
}

package com.jpa3.clothes.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sale_clothing")
public class SalePOC {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Sale sale;

    @ManyToOne
    @JoinColumn(nullable = false)
    private PieceOfClothing clothing;
}

package com.jpa3.clothes.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "prenda")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PieceOfClothing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    @Column()
    private String name;
    @Column()
    private String type;
    @Column()
    private String brand;
    @Column()
    private String color;
    @Column()
    private String size;
    @Column()
    private Integer amount;
    @Column()
    private Double price;

    @OneToMany(mappedBy = "clothing")
    @JsonBackReference
    private Set<SalePOC> salePOCs;
}

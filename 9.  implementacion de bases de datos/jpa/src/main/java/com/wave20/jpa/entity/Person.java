package com.wave20.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

//@Data // @ToString @HashAndEquals @Getter @Setter
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity // Levantar un objeto base de esta clase en el contenedor de spring
@Table(name= "persona") // Para darle configuraciones a esta tabla, como por ejemplo un nombre diferente.
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "documento_identidad", length = 10)
    private String dni;

    @Column(scale = 2)
    private Integer edad;

    @Column(length = 50)
    private String direccion;

    @Column(length = 20)
    private String telefono;

}

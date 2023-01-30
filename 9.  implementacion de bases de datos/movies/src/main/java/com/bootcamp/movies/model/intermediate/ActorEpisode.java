package com.bootcamp.movies.model.intermediate;

import com.bootcamp.movies.model.Actor;
import com.bootcamp.movies.model.Episode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "actor_episode")
public class ActorEpisode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Actor actor;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Episode episode;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}

//@Entity
//@Table(name="order_item")
//public class OrderItem {
//    @ManyToOne
//    private Order order;
//    @ManyToOne
//    private Product product;
//}
//
//@Entity
//public class Order {
//    @OneToMany (mappedBy = "order")
//    private Set<OrderItem> orderItems;
//}
//
//@Entity
//public class Product {
//    @OneToMany(mappedBy = "product")
//    private Set<OrderItem> orderItems;
//}
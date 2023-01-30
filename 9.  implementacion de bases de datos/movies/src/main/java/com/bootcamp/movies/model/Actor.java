package com.bootcamp.movies.model;

import com.bootcamp.movies.model.intermediate.ActorEpisode;
import com.bootcamp.movies.model.intermediate.ActorMovie;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private Double rating;
    @ManyToOne
    private Movie favoriteMovie;
    @OneToMany(mappedBy = "actor")
    private Set<ActorEpisode> actorEpisodes;
    @OneToMany(mappedBy = "actor")
    @JsonManagedReference
    private Set<ActorMovie> actorMovies;
}

//@Entity
//public class Order {
//    @OneToMany (mappedBy = "order")
//    private Set<OrderItem> orderItems;
//}

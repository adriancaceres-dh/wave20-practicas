package com.example.Practica.HQL.model.relationships;

import com.example.Practica.HQL.model.Actor;
import com.example.Practica.HQL.model.Episode;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="actor_episode")
public class ActorEpisode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) unsigned")
    private Integer id;
    @Column(columnDefinition = "timestamp")
    private LocalDate createdAt;
    @Column(columnDefinition = "timestamp")
    private LocalDate updatedAt;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false, columnDefinition = "int(11) unsigned")
    private Actor actor;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false, columnDefinition = "int(11) unsigned")
    private Episode episode;

}

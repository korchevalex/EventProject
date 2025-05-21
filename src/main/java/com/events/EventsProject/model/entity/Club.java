package com.events.EventsProject.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "clubs")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String organiser;
    @Column(nullable = false)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String themes;

    public boolean hasThemes() {
        return themes != null;
    }
}

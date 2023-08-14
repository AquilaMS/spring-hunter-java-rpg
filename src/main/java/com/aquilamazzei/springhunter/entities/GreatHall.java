package com.aquilamazzei.springhunter.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
public class GreatHall implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Hero hero;

    public GreatHall(Hero hero) {
        this.hero = hero;
    }
}

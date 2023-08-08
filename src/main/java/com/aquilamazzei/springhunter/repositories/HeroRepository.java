package com.aquilamazzei.springhunter.repositories;

import com.aquilamazzei.springhunter.entities.Hero;
import com.aquilamazzei.springhunter.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeroRepository extends JpaRepository<Hero, Long> {

    List<Hero> findAllByPlayer(Player player);
}

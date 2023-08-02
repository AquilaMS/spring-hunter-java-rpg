package com.aquilamazzei.springhunter.repositories;

import com.aquilamazzei.springhunter.entities.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Long> {
}

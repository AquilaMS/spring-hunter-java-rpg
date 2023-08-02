package com.aquilamazzei.springhunter.repositories;

import com.aquilamazzei.springhunter.entities.Monster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonsterRepository extends JpaRepository<Monster, Long> {
}

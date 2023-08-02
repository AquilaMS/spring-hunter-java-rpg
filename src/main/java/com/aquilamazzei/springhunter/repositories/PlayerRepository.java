package com.aquilamazzei.springhunter.repositories;

import com.aquilamazzei.springhunter.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}

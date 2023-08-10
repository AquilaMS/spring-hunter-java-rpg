package com.aquilamazzei.springhunter.repositories;

import com.aquilamazzei.springhunter.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findByUsernameOrEmail(String username, String email);
    UserDetails findByUsername(String username);
}

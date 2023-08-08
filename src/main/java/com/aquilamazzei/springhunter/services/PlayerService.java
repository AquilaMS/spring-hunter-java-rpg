package com.aquilamazzei.springhunter.services;

import com.aquilamazzei.springhunter.dto.User.CreateAccountDTO;
import com.aquilamazzei.springhunter.dto.User.LoginDTO;
import com.aquilamazzei.springhunter.entities.Player;
import com.aquilamazzei.springhunter.repositories.PlayerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    private PasswordEncoder passwordEncoder;

    public Player createNewAccount(CreateAccountDTO account) {
        List<Player> verifyPlayer = playerRepository.findByUsernameOrEmail(account.username(), account.email());
        if (verifyPlayer.isEmpty()) {
            Player newPlayer = new Player();
            BeanUtils.copyProperties(account, newPlayer);
            newPlayer.setPassword(passwordEncoder.encode(newPlayer.getPassword()));
            playerRepository.save(newPlayer);
            return newPlayer;
        } else return null;
    }

    public UserDetails loginUser(LoginDTO account) {
        UserDetails player = playerRepository.findByUsername(account.username());
        boolean isValidPassword = passwordEncoder.matches(account.password(), player.getPassword());
        if (isValidPassword) {
            return player;
        }
        return null;
    }
}


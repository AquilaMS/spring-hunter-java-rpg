package com.aquilamazzei.springhunter.services;

import com.aquilamazzei.springhunter.entities.Player;
import com.aquilamazzei.springhunter.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public void teste(){

    }
}

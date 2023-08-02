package com.aquilamazzei.springhunter.resources;

import com.aquilamazzei.springhunter.services.PlayerService;
import com.aquilamazzei.springhunter.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerResource {

    @Autowired
    PlayerService playerService;

    @Autowired
    TypeService typeService;

    @GetMapping("/inserir")
    public void ttt(){

        playerService.teste();
    }
}

package com.aquilamazzei.springhunter.resources;

import com.aquilamazzei.springhunter.entities.GreatHall;
import com.aquilamazzei.springhunter.repositories.GreatHallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("greathall")
public class GreatHallResources {

    @Autowired
    private GreatHallRepository greatHallRepository;

    @GetMapping
    public ResponseEntity<List<GreatHall>> getGreatHall(){
        return null;
       // return ResponseEntity.ok(greatHallRepository.findAll());
    }
}

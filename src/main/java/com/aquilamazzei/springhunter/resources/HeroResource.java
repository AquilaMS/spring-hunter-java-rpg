package com.aquilamazzei.springhunter.resources;

import com.aquilamazzei.springhunter.dto.Hero.CreateHeroDTO;
import com.aquilamazzei.springhunter.dto.Hero.OwnedByPlayerById;
import com.aquilamazzei.springhunter.entities.Hero;
import com.aquilamazzei.springhunter.entities.HeroClass;
import com.aquilamazzei.springhunter.services.HeroService;
import com.aquilamazzei.springhunter.utils.enums.ClassNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hero")
public class HeroResource {

    @Autowired
    HeroService heroService;

    //TODO: ISSO AQUI
    @PostMapping("/create")
    public ResponseEntity createHero(@RequestBody CreateHeroDTO createHeroDTO){
        Hero insertedHero = heroService.insertHero(createHeroDTO);
        return ResponseEntity.ok(insertedHero);
    }

    @GetMapping("/allbyplayer")
    public ResponseEntity getAllHeroesByPlayer(){
        List<Hero> gotHeroes = heroService.getAllHeroesByLoggedPlayer();
        return ResponseEntity.ok(gotHeroes);
    }

    @GetMapping("/getownedbyid")
    public ResponseEntity getHeroOwnedByPlayerById(@RequestBody OwnedByPlayerById index){
        Hero gotHero = heroService.getHeroOwnedByPlayerById(index);
        return ResponseEntity.ok(gotHero);
    }

}

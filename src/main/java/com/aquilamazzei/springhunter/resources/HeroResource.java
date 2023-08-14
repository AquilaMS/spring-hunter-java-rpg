package com.aquilamazzei.springhunter.resources;

import com.aquilamazzei.springhunter.dto.Hero.CreateHeroDTO;
import com.aquilamazzei.springhunter.dto.Hero.OwnedByPlayerById;
import com.aquilamazzei.springhunter.dto.Hero.ResponseCreatedHero;
import com.aquilamazzei.springhunter.dto.SimpleMessage;
import com.aquilamazzei.springhunter.entities.Hero;
import com.aquilamazzei.springhunter.entities.Weapon;
import com.aquilamazzei.springhunter.services.HeroService;
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

    @PostMapping("/create")
    public ResponseEntity createHero(@RequestBody CreateHeroDTO createHeroDTO){
        ResponseCreatedHero insertedHero = heroService.insertHero(createHeroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(insertedHero);
    }

    @GetMapping("/all")
    public ResponseEntity getAllHeroesByPlayer(){
        List<ResponseCreatedHero> gotHeroes = heroService.getAllHeroesByLoggedPlayerFiltered();
        return ResponseEntity.status(HttpStatus.OK).body(gotHeroes);
    }

    @GetMapping("/allalive")
    public ResponseEntity getAllHeroesAliveByPlayer(){
        List<ResponseCreatedHero> gotHeroes = heroService.getAllHeroesAliveFiltered();
        return ResponseEntity.status(HttpStatus.OK).body(gotHeroes);
    }

    @GetMapping("/getweapon")
    public ResponseEntity getHeroWeapon(@RequestBody OwnedByPlayerById index){
        List<Hero> gotHeroes = heroService.getHeroesByPlayerNonFiltered();
        Weapon gotWeapon = gotHeroes.get(index.index()).getWeapon();
        if (gotWeapon == null){return ResponseEntity.status(HttpStatus.OK).body(new SimpleMessage("None"));}
        return ResponseEntity.status(HttpStatus.OK).body(gotWeapon);
    }

    @GetMapping("/onealive")
    public ResponseEntity getAllHeroesAliveByPlayer(@RequestBody OwnedByPlayerById index){
        Hero gotHero = heroService.getHeroesAliveByPlayerById(index);
        ResponseCreatedHero responseCreatedHero = new ResponseCreatedHero(
                gotHero.getHeroProfession().getId(),
                gotHero.getPeonName(),
                gotHero.getLevel(),
                gotHero.getHeroProfession().getClassName(),
                gotHero.getDamage(),
                gotHero.getDefense(),
                gotHero.getLife(),
                gotHero.getExperience(),
                gotHero.getIsAlive(),
                gotHero.getGold(),
                gotHero.getWeapon()
        );
        return ResponseEntity.status(HttpStatus.OK).body(responseCreatedHero);
    }

}

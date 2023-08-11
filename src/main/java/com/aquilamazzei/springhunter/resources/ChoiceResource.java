package com.aquilamazzei.springhunter.resources;

import com.aquilamazzei.springhunter.dto.Choice.ChosenOption;
import com.aquilamazzei.springhunter.dto.SimpleMessage;
import com.aquilamazzei.springhunter.entities.Hero;
import com.aquilamazzei.springhunter.services.HeroService;
import com.aquilamazzei.springhunter.utils.Choices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("game")
public class ChoiceResource {

    @Autowired
    private HeroService heroService;


    @GetMapping
    public ResponseEntity generateChoices() {

        List<Choices> choicesList = new ArrayList<>();
        List<Integer> tempOrdinalList = new ArrayList<>();

        while (choicesList.size() < 3) {
            Choices choices = new Choices();
            int newOrdinal = choices.generatedOption.ordinal();

            if (!tempOrdinalList.contains(newOrdinal)) {
                tempOrdinalList.add(newOrdinal);
                choicesList.add(choices);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(choicesList);
    }

    @PostMapping
    public ResponseEntity chooseOption(@RequestBody ChosenOption chosenOption){
        Hero hero = heroService.getHeroesAliveByPlayerById(chosenOption.index());
        if (hero.getGold() >= 50){
            Choices choices = new Choices();
            SimpleMessage message = new SimpleMessage(choices.chosenOption(hero,chosenOption.choices().getGeneratedOption(), heroService));
            hero.setGold(hero.getGold() - 50);
            heroService.updateHero(hero);

            return ResponseEntity.ok(message);
        }else {
            SimpleMessage message = new SimpleMessage("Not Enough Gold");
            return ResponseEntity.ok(message);
        }

        /*
         * {
         * 	"choices": {
         * 		"title": "Train Tactics",
         * 		"description": "Increase Experience",
         * 		"generatedOption": "EARN_EXPERIENCE"
         *        },
         * 	"index": {
         * 		"index": 2
         *    }
         * }
         */
    }
}

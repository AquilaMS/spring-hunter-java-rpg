package com.aquilamazzei.springhunter.resources;

import com.aquilamazzei.springhunter.utils.Choices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("game")
public class ChoiceResource {

    List<Choices> tempChoiceList = new ArrayList<>();

    @GetMapping
    public ResponseEntity generateChoices() {
        tempChoiceList.clear();

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

   /* @PostMapping
    public ResponseEntity chooseOption(@RequestBody )
*/}

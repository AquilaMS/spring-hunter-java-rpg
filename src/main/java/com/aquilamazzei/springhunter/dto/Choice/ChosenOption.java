package com.aquilamazzei.springhunter.dto.Choice;

import com.aquilamazzei.springhunter.dto.Hero.OwnedByPlayerById;
import com.aquilamazzei.springhunter.utils.Choices;

public record ChosenOption(Choices choices, OwnedByPlayerById index) {
}

package com.aquilamazzei.springhunter.logics;

import lombok.Data;

import java.util.Random;


public class Dice {

    private final Random dice;

    public Dice() {
        this.dice = new Random();
    }

    public Integer roll(){
        return dice.nextInt(20);
    }
}

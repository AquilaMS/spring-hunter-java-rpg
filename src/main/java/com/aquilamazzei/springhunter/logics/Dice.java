package com.aquilamazzei.springhunter.logics;

import java.nio.DoubleBuffer;
import java.util.Random;


public class Dice {


    public static Integer rollD20(){
        return new Random().nextInt(20) + 1;
    }

    public static Integer rollCustom(Integer maxValue){
        return new Random().nextInt(maxValue);
    }

    public static Double rollDouble(){
        return new Random().nextDouble();
    }
}
